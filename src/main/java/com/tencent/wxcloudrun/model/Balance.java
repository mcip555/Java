package com.tencent.wxcloudrun.model;

import java.beans.Transient;
import java.util.Date;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Balance {
    private Integer id;

    private Date createtime;

    private Date modifytime;

    private String creater;

    private String modifier;

    private Integer deleted;

    private Integer cardId;


    private String avatarUrl;


    private Double changeBalance;



}