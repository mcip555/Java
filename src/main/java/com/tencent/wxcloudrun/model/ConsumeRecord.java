package com.tencent.wxcloudrun.model;

import java.util.Date;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ConsumeRecord {
    private Integer id;

    private String creater;

    private Date createtime;

    private String modifier;

    private Date modifytime;

    private Integer deleted;
    private Integer consumeId;
    private Integer cardId;


    private String bankName;
    private String cardNo;
    private String userName;
}