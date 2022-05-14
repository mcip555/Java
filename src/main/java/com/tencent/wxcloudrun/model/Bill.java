package com.tencent.wxcloudrun.model;

import java.util.Date;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Bill {


    public Bill(Integer id ,String modifier, Date modifyTime, Integer status, Date endTime){
        this.id = id;
        this.modifier = modifier;
        this.modifyTime = modifyTime;
        this.status = status;
        this.endTime = endTime;
    }

    private Integer id;

    private String creater;

    private Date createTime;

    private String modifier;

    private Date modifyTime;

    //删除状态，0、未删除，1、已删除
    private Integer deleted;
    private Integer cardId;

    //账单状态，10、待更新账单，20、待还款，30、已还款
    private Integer status;

    private Date endTime;

    private String bankName;
    private String cardNo;
    private String userName;
    private Integer billYear;
    private Integer billMonth;
    private Integer type;
    private Date billDate;
    private Date payDate;


    private Double lastConsume;
    private Double balance;




}