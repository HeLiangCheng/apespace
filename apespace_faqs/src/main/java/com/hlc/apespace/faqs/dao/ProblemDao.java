package com.hlc.apespace.faqs.dao;

import com.hlc.apespace.faqs.entity.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
    *@ClassName 问答数据持久化
    *@Description 问答数据持久化
    *@Author Liang
    *@Date 2019/1/29 16:33
    *@Version 1.0
**/
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem> {

    /**
     * 根据标签ID查询最新问题列表
     *
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where id in( select problemid from ProblemLabel where labelid=?1 ) order by replytime desc")
    Page<Problem> findNewListByLabelId(String labelId, Pageable pageable);

    /**
     * 根据标签ID查询热门问题列表
     *
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where id in ( select problemid from ProblemLabel where labelid=?1 ) order by reply desc")
    Page<Problem> findHotListbyLabelId(String labelId, Pageable pageable);

    /**
     * 等待回答的问题列表
     *
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where id in ( select problemid from ProblemLabel where labelid=?1 ) and reply=0 order by createtime desc")
    Page<Problem> findWaitListbyLabelId(String labelId, Pageable pageable);

}










