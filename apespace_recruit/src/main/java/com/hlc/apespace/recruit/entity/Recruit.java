package com.hlc.apespace.recruit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
    *@ClassName Recruit
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 13:26
    *@Version 1.0
**/
@Data
@Entity
@Table(name="tb_recruit")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Recruit {

    /**
     * 主键
     */
    @Id
    private String id;
    /**
     * 职位名称
     */
    private String jobname;
    /**
     * 薪资范围
     */
    private String salary;
    /**
     * 经验要求
     */
    private String condition;
    /**
     * 学历要求
     */
    private String education;
    /**
     * 任职方式
     */
    private String type;
    /**
     * 办公地址
     */
    private String address;
    /**
     * 企业ID
     */
    private String eid;
    /**
     * 创建日期
     */
    private Date createtime;
    /**
     * 状态
     */
    private String state;
    /**
     * 网址
     */
    private String url;
    /**
     * 标签
     */
    private String label;
    /**
     * 职位描述
     */
    private String content1;
    /**
     * 职位要求
     */
    private String content2;

}

