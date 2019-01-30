package com.hlc.apespace.article.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
    *@ClassName Article
    *@Description 文章
    *@Author Liang
    *@Date 2019/1/30 9:02
    *@Version 1.0
**/
@Data
@Table(name="tb_article")
@Entity
public class Article {

    /**
     * 主键ID
     */
    @Id
    private String id;
    /**
     * 专栏ID
     */
    private String columnid;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 标题
     */
    private String title;
    /**
     * 文章正文
     */
    private String content;
    /**
     * 文章封面
     */
    private String image;
    /**
     * 发表日期
     */
    private Date createtime;
    /**
     * 修改日期
     */
    private Date updatetime;
    /**
     * 是否公开
     */
    private String ispublic;
    /**
     * 是否置顶
     */
    private String istop;
    /**
     * 浏览量
     */
    private Integer visits;
    /**
     * 点赞数
     */
    private Integer thumbup;
    /**
     * 评论数
     */
    private Integer comment;
    /**
     * 审核状态
     */
    private String state;
    /**
     * 所属频道
     */
    private String channelid;
    /**
     * URL
     */
    private String url;
    /**
     * 类型
     */
    private String type;

}
