package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.BillMapper;
import com.tencent.wxcloudrun.model.*;
import com.tencent.wxcloudrun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BillInfoServiceImpl implements BillInfoService {


    @Resource
    private BillMapper billMapper;

    @Autowired
    protected BillService billService;

    @Autowired
    protected PayService payService;

    @Autowired
    protected UserinfoService userinfoService;

    @Autowired
    protected BalanceService balanceService;

    @Autowired
    protected CardService cardService;

    @Autowired
    protected BillRecordService billRecordService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return billMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Bill record) {
        return billMapper.insert(record);
    }

    @Override
    public int insertSelective(Bill record) {
        return billMapper.insertSelective(record);
    }

    @Override
    public Bill selectByPrimaryKey(Integer id) {
        return billMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Bill record) {
        return billMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Bill record) {
        return billMapper.updateByPrimaryKey(record);
    }



    @Override
    public BillInfo selectByBillId(Integer billId) {

        Bill bill = billService.selectByPrimaryKey(billId);
        if(null == bill){
            return null;
        }
        List<Pay> payList = payService.selectListByBillIdOrderByCreateTimeDescLimit20(billId);

        for (Pay pay: payList
             ) {
            String creater = pay.getCreater();

            Userinfo userinfo = userinfoService.selectByUserId(creater);
            if(null == userinfo){
                continue;
            }
            pay.setAvatarUrl(userinfo.getAvatarUrl());
        }

        Integer cardId = bill.getCardId();
        List<Balance> balanceList = balanceService.selectListByCardIdOrderByCreateTimeDescLimit20(cardId);
        for (Balance balance:balanceList
             ) {
            String creater = balance.getCreater();

            Userinfo userinfo = userinfoService.selectByUserId(creater);
            if(null == userinfo){
                continue;
            }
            balance.setAvatarUrl(userinfo.getAvatarUrl());
        }

        Card card = cardService.selectByPrimaryKey(cardId);
        List<BillRecord> billrecordList =billRecordService.selectListByBillIdOrderByCreateTimeDesc(billId);

        for (BillRecord billrecord:billrecordList
             ) {
            String creater = billrecord.getCreater();
            Userinfo userinfo = userinfoService.selectByUserId(creater);
            if(null == userinfo){
                continue;
            }

            billrecord.setAvatarUrl(userinfo.getAvatarUrl());
        }

        BillInfo billInfo = new BillInfo(bill,payList,balanceList,card,billrecordList);

        return billInfo;
    }

    @Override
    public Boolean closeBill(Integer billId) {
        return null;
    }

    @Override
    public Boolean updateBillStatusAndEndTime(Integer billId) {
        return null;
    }


    @Transactional
    public Boolean closeBill(Integer billId,String userId) {


        //读取本期账单
        Bill bill = billService.selectByPrimaryKey(billId);
        if(null == bill){
            throw new RuntimeException();
        }

        //读取本期账单所属卡
        Card card = cardService.selectByPrimaryKey(bill.getCardId());
        if(null == card){
            throw new RuntimeException();
        }

        //关闭本期账单
        Bill billOld = new Bill(
                billId,
                userId,
                new Date(),
                30,
                new Date()
        );

        if(0 == billService.updateStatusAndEndTimeByPrimaryKey(billOld)){
            throw new RuntimeException();
        }

        //登记关闭本期账单记录
        BillRecord billRecord = new BillRecord(
                null,
                userId,
                new Date(),
                userId,
                new Date(),
                0,
                billId,
                null,
                "status",
                "状态",
                "20",
                "30"
        );
        if(0 == billRecordService.insert(billRecord)){
            throw new RuntimeException();
        }


        //生成下期账单
        Integer billNewBillYear = bill.getBillYear();
        Integer billNewBillMonth = bill.getBillMonth()+1;
        if(billNewBillMonth > 12){
            billNewBillYear++;
            billNewBillMonth = 1;
        }
        Integer billNewBillDay = card.getBillDay();
        Integer billNewPayDay = card.getPayDay();
        Date billNewBillDate = this.getBillNewBillDate(billNewBillYear,billNewBillMonth,billNewBillDay);
        Date billNewPayDate = this.getBillNewPayDate(billNewBillYear,billNewBillMonth,billNewPayDay,billNewBillDate);

        Bill billNew = new Bill(
                null,
                userId,
                new Date(),
                userId,
                new Date(),
                0,
                bill.getCardId(),
                10,
                null,
                bill.getBankName(),
                bill.getCardNo(),
                bill.getUserName(),
                billNewBillYear,
                billNewBillMonth,
                bill.getType(),
                billNewBillDate,
                billNewPayDate,
                null,
                null
        );

        if(0 == billService.insert(billNew)){
            throw new RuntimeException();
        }

        return true;
    }



    private Date getBillNewPayDate(int billNewYear,int billNewMonth,int payDay,Date billDate){
        Date payDate = findNearDay(billNewYear,billNewMonth,payDay);
        if((payDate.getTime() - billDate.getTime())<=0){
            return findNearDay(billNewYear,billNewMonth+1,payDay);
        }else{
            return payDate;
        }
    }


    private Date getBillNewBillDate(int billNewYear,int billNewMonth,int billDay){
        return findNearDay(billNewYear,billNewMonth,billDay);
    }

    private Date findNearDay(int year,int month,int day){

        int _year = year;
        int _month = month-1;
        int _day = day;

        Calendar cal = Calendar.getInstance();

        cal.set(_year,_month,_day);

        if(year != cal.get(Calendar.YEAR) || month  != (cal.get(Calendar.MONTH)+1) || day !=cal.get(Calendar.DATE)){
            return findNearDay(year, month, day-1);
        }

        return cal.getTime();
    }





}
