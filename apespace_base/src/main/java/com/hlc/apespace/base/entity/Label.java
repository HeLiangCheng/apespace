package com.hlc.apespace.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
    *@ClassName Label
    *@Description todo
    *@Author Liang
    *@Date 2019/1/28 14:24
    *@Version 1.0
**/
@Entity
@Table(name = "tb_label")
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Label {

    /**
     * 标签主键ID
     */
    @Id
    private String id;
    /**
     * 标签名称
     */
    private String labelname;
    /**
     * 状态
     */
    private String state;
    /**
     * 使用数量
     */
    private long count;
    /**
     *  是否推荐
     */
    private String recommend;
    /**
     * 粉丝数
     */
    private long fans;

}
