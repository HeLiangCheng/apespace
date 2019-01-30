package com.hlc.apespace.article.dao;

import com.hlc.apespace.article.entity.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName ColumnDao
 * @Description todo
 * @Author Liang
 * @Date 2019/1/30 9:12
 * @Version 1.0
 **/

public interface ColumnDao extends JpaRepository<Column,String>,JpaSpecificationExecutor<Column> {

}
