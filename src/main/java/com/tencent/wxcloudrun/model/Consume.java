package com.tencent.wxcloudrun.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Consume {
    private Integer id;

    private String creater;

    private Date createtime;

    private String modifier;

    private Date modifytime;

    private Integer deleted;
}