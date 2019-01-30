package com.hlc.apespace.spitslot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
    *@ClassName Spitslot
    *@Description 吐槽
    *@Author Liang
    *@Date 2019/1/30 14:00
    *@Version 1.0
**/
@Data
public class Spitslot implements Serializable {

    @Id
    private String _id;
    private String content;
    private Date publishtime;
    private String userid;
    private String nickname;
    private Integer visits;
    private Integer thumbup;
    private Integer share;
    private Integer comment;
    private String state;
    private String parentid;

}
