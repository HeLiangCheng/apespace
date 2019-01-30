package com.hlc.apespace.gathering.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
    *@ClassName UsergathPrimaryKey
    *@Description todo
    *@Author Liang
    *@Date 2019/1/30 13:34
    *@Version 1.0
**/

@Data
@Embeddable
public class UsergathPrimaryKey implements Serializable {

    /**
     * 用户ID
     */
    @Column(name = "userid")
    private String userid;

    /**
     * 活动ID
     */
    @Column(name = "gathid")
    private String gathid;

}