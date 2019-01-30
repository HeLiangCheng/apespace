package com.hlc.apespace.faqs.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
    *@ClassName Reply
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 16:18
    *@Version 1.0
**/
@Data
@Table(name="tb_reply")
@Entity
public class Reply implements Serializable {

    /**
     * 编号
     */
    @Id
    private String id;
    /**
     * 问题ID
     */
    private String problemid;
    /**
     * 回答内容
     */
    private String content;
    /**
     * 创建日期
     */
    private Date createtime;
    /**
     * 更新日期
     */
    private Date updatetime;
    /**
     * 回答人ID
     */
    private String userid;
    /**
     * 回答人昵称
     */
    private String nickname;

}
