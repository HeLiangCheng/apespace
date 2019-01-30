package com.hlc.apespace.faqs.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
    *@ClassName UserLabel
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 16:19
    *@Version 1.0
**/
@Data
@Entity
@Table(name="tb_ul")
public class UserLabel implements Serializable {

    /**
     *用户ID
     */
    @Id
    private String uid;

    /**
     *标签ID
     */
    @Id
    private String lid;

}
