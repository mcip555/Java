package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.BalanceRequest;
import com.tencent.wxcloudrun.dto.BillInfoRequest;
import com.tencent.wxcloudrun.dto.CloseBillRequest;
import com.tencent.wxcloudrun.dto.TestRequest;
import com.tencent.wxcloudrun.model.Balance;
import com.tencent.wxcloudrun.model.Bill;
import com.tencent.wxcloudrun.model.BillInfo;
import com.tencent.wxcloudrun.service.BalanceService;
import com.tencent.wxcloudrun.service.BillInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
* (balance)表控制层
*
* @author xxxxx
*/
@RestController
public class BillInfoController {
    final BillInfoService billInfoService;
    final Logger logger;
    public BillInfoController(@Autowired BillInfoService billInfoService) {
        this.billInfoService = billInfoService;
        this.logger = LoggerFactory.getLogger(BillInfoController.class);
    }

    @PostMapping(value = "/api/billInfo/selectByBillId")
    ApiResponse selectByBillId(@RequestBody BillInfoRequest request){
        logger.info("/api/count post request, action: {}", request.getBillId());
        BillInfo billInfo = billInfoService.selectByBillId(request.getBillId());
        return ApiResponse.ok(billInfo);
    }

    @PostMapping(value = "/api/billInfo/closeBill")
    ApiResponse closeBill(@RequestBody CloseBillRequest request){
        logger.info("/api/count post request, action: {}", request.getBillId());
        Boolean closeBill = billInfoService.closeBill(request.getBillId());
        return ApiResponse.ok(closeBill);
    }




}
