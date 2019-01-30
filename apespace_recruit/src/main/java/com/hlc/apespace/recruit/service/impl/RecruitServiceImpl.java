package com.hlc.apespace.recruit.service.impl;

import com.hlc.apespace.common.util.IdWorker;
import com.hlc.apespace.recruit.dao.RecruitDao;
import com.hlc.apespace.recruit.entity.Recruit;
import com.hlc.apespace.recruit.service.RecruitService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
    *@ClassName RecruitServiceImpl
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 13:49
    *@Version 1.0
**/
@Service
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    private RecruitDao recruitDao;
    @Autowired
    private IdWorker idWorker;

    @Override
    public void save(Recruit recruit) {
        recruit.setId(idWorker.nextId() + "");
        recruitDao.save(recruit);
    }

    @Override
    public Recruit getRecruit(String id) {
        return recruitDao.getOne(id);
    }

    @Override
    public Page<Recruit> listRecruitByPage(int pageSize, int pageIndex, Recruit recruit) {
        Specification<Recruit> specification = new Specification<Recruit>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Recruit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                if (StringUtils.isNotEmpty(recruit.getJobname())) {
                    predicateList.add(cb.like(root.get("jobname").as(String.class), "%" + recruit.getJobname() + "%"));
                }
                if (StringUtils.isNotEmpty(recruit.getSalary())) {
                    predicateList.add(cb.equal(root.get("salary").as(String.class), recruit.getSalary()));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        PageRequest page = PageRequest.of(pageIndex - 1, pageSize);
        return recruitDao.findAll(specification, page);
    }

    @Override
    public long count(Recruit recruit) {
        Specification<Recruit> specification = new Specification<Recruit>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Recruit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                if (StringUtils.isNotEmpty(recruit.getJobname())) {
                    predicateList.add(cb.like(root.get("jobname").as(String.class), "%" + recruit.getJobname() + "%"));
                }
                if (StringUtils.isNotEmpty(recruit.getSalary())) {
                    predicateList.add(cb.equal(root.get("salary").as(String.class), recruit.getSalary()));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        return recruitDao.count(specification);
    }

    @Override
    public void delete(String id) {
        recruitDao.deleteById(id);
    }

    @Override
    public void update(Recruit recruit) {
        recruitDao.save(recruit);
    }

    @Override
    public List<Recruit> listLatestByStateOrder(String state) {
        return recruitDao.findTop5ByStateOrderByCreatetimeDesc(state);
    }

}
