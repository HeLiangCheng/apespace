package com.hlc.apespace.faqs.dao;

import com.hlc.apespace.faqs.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
    *@ClassName 问题回答持久化
    *@Description 问题回答持久化
    *@Author Liang
    *@Date 2019/1/29 16:34
    *@Version 1.0
**/

public interface ReplyDao extends JpaRepository<Reply,String>,JpaSpecificationExecutor<Reply> {
}
