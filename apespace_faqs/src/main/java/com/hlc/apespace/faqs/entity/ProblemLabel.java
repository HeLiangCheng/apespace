package com.hlc.apespace.faqs.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
    *@ClassName ProblemLabel
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 16:17
    *@Version 1.0
**/
@Data
@Table(name="tb_pl")
@Entity
public class ProblemLabel implements Serializable {

    /**
     *问题ID
     */
    @Id
    private String problemid;

    /**
     *标签ID
     */
    @Id
    private String labelid;

}
