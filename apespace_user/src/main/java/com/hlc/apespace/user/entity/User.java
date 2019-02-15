package com.hlc.apespace.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
    *@ClassName User
    *@Description todo
    *@Author Liang
    *@Date 2019/1/31 14:22
    *@Version 1.0
**/
@Data
@Table(name = "tb_user")
@Entity
public class User implements Serializable {

    /**
     * ID 主键
     */
    @Id
    private String id;
    private String mobile;
    private String password;
    private String nickname;
    private String sex;
    private Date birthday;
    private String avatar;
    private String email;
    private Date regdate;
    private Date updatedate;
    private Date lastdate;
    private long online;
    private String interest;
    private String personality;
    private int fanscount;
    private int followcount;

}
