package com.hlc.apespace.recruit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
    *@ClassName Enterprise
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 13:18
    *@Version 1.0
**/
@Data
@Table(name="tb_enterprise")
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Enterprise {

    /**
     * 主键ID
     */
    @Id
    private String id;
    /**
     * 企业名称
     */
    private String name;
    /**
     * 企业简介
     */
    private String summary;
    /**
     * 企业地址
     */
    private String address;
    /**
     * 标签列表
     */
    private String labels;
    /**
     * 坐标
     */
    private String coordinate;
    /**
     * 是否热门
     */
    private String ishot;
    /**
     * logo
     */
    private String logo;
    /**
     * 职位数量
     */
    private Integer jobcount;
    /**
     * URL
     */
    private String url;

}
