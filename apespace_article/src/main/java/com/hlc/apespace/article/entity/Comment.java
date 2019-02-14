package com.hlc.apespace.article.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
    *@ClassName Comment
    *@Description todo
    *@Author Liang
    *@Date 2019/1/31 10:25
    *@Version 1.0
**/
@Data
public class Comment implements Serializable {

    @Id
    private String _id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;
    private Date publishdate;

}
