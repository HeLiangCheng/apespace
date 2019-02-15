package com.hlc.apespace.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
    *@ClassName Admin
    *@Description todo
    *@Author Liang
    *@Date 2019/1/31 14:18
    *@Version 1.0
**/
@Data
@Table(name = "tb_admin")
@Entity
public class Admin implements Serializable {

    @Id
    private String id;
    private String loginname;
    private String password;
    private String state;

}
