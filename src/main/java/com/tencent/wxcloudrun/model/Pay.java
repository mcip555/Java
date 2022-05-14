package com.tencent.wxcloudrun.model;

import java.beans.Transient;
import java.util.Date;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pay  {
    private Integer id;

    private String creater;

    private Date createtime;

    private String modifier;

    private Date modifytime;

    private Integer deleted;

    private Integer billid;

    private String avatarUrl;








}