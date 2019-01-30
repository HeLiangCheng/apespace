package com.hlc.apespace.faqs.service;

import com.hlc.apespace.faqs.dao.ProblemDao;
import com.hlc.apespace.faqs.entity.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
    *@ClassName ProblemService
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 16:51
    *@Version 1.0
**/

@Service
public class ProblemService {

    @Autowired
    private ProblemDao problemDao;

    /**
     * 根据标签ID查询问题列表
     *
     * @param lableId 标签Id
     * @param page    页码
     * @param size    页大小
     * @return
     */
    public Page<Problem> findNewListByLabelId(String labelid, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Problem> problems = problemDao.findNewListByLabelId(labelid, pageRequest);
        return problems;
    }


    /**
     * 根据标签ID查询问题列表
     *
     * @param labelId 标签Id
     * @param page    页码
     * @param size    页大小
     * @return
     */
    public Page<Problem> findHotListbyLabelId(String labelid, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Problem> problems = problemDao.findHotListbyLabelId(labelid, pageRequest);
        return problems;
    }

    /**
     * 获取等待回答的问题列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    public Page<Problem> findWaitListbyLabelId(String labelid, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Problem> problems = problemDao.findWaitListbyLabelId(labelid, pageRequest);
        return problems;
    }


}
