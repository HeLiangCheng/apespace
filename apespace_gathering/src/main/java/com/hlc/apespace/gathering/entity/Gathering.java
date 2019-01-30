package com.hlc.apespace.gathering.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
    *@ClassName Gathering
    *@Description todo
    *@Author Liang
    *@Date 2019/1/30 13:18
    *@Version 1.0
**/
@Data
@Entity
@Table(name="tb_gathering")
public class Gathering {

    /**
     * 主键
     */
    @Id
    private String id;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 大会简介
     */
    private String summary;
    /**
     * 详细说明
     */
    private String detail;
    /**
     * 主办方
     */
    private String sponsor;
    /**
     * 活动图片
     */
    private String image;
    /**
     * 开始时间
     */
    private Date starttime;
    /**
     * 截止时间
     */
    private Date endtime;
    /**
     * 举办地点
     */
    private String address;
    /**
     * 报名截止
     */
    private Date enrolltime;
    /**
     * 是否可见
     */
    private String state;
    /**
     * 城市
     */
    private String city;
}
