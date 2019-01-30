package com.hlc.apespace.article.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
    *@ClassName Channel
    *@Description 频道
    *@Author Liang
    *@Date 2019/1/30 9:05
    *@Version 1.0
**/
@Data
@Entity
@Table(name="tb_channel")
public class Channel {

    /**
     * 主键ID
     */
    @Id
    private String id;
    /**
     *频道名称
     */
    private String name;
    /**
     *状态
     */
    private String state;

}
