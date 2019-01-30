package com.hlc.apespace.gathering.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
    *@ClassName Usergath
    *@Description todo
    *@Author Liang
    *@Date 2019/1/30 13:18
    *@Version 1.0
**/
@Data
@Entity
@Table(name="tb_usergath")
public class Usergath {

    @EmbeddedId
    private UsergathPrimaryKey id;

    /**
     * 点击时间
     */
    private Date exetime;

}
