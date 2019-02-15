package com.hlc.apespace.user.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
    *@ClassName Follow
    *@Description todo
    *@Author Liang
    *@Date 2019/1/31 14:21
    *@Version 1.0
**/
@Data
@Entity
@Table(name = "tb_follow")
public class Follow implements Serializable{

    /**
     * 用户ID
     */
    @Id
    @Column(name = "userid", nullable = false)
    private String userid;

    /**
     * 被关注用户ID
     */
    @Id
    @Column(name = "targetuser", nullable = false)
    private String targetuser;

}
