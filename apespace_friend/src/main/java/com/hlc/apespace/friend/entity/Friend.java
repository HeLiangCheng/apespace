package com.hlc.apespace.friend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
    *@ClassName Friend
    *@Description todo
    *@Author Liang
    *@Date 2019/2/15 9:04
    *@Version 1.0
**/
@Data
@Entity
@Table(name = "tb_friend")
@IdClass(Friend.class)
public class Friend implements Serializable {

    @Id
    private String userid;
    @Id
    private String friendid;
    private String islike;

}
