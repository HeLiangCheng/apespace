package com.hlc.apespace.article.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
    *@ClassName Column
    *@Description 专栏
    *@Author Liang
    *@Date 2019/1/30 9:07
    *@Version 1.0
**/
@Data
@Entity
@Table(name="tb_column")
public class Column {

    /**
     * 主键ID
     */
    @Id
    private String id;
    /**
     * 专栏名称
     */
    private String name;
    /**
     * 专栏简介
     */
    private String summary;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 申请日期
     */
    private Date createtime;
    /**
     * 审核日期
     */
    private Date checktime;
    /**
     * 状态
     */
    private String state;

}
