package com.hlc.apespace.recruit.service.impl;

import com.hlc.apespace.common.util.IdWorker;
import com.hlc.apespace.recruit.dao.EnterpriseDao;
import com.hlc.apespace.recruit.entity.Enterprise;
import com.hlc.apespace.recruit.service.EnterpriseService;
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
    *@ClassName EnterpriseServiceImpl
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 13:49
    *@Version 1.0
**/
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;
    @Autowired
    private IdWorker idWorker;

    @Override
    public void save(Enterprise enterprise) {
        enterprise.setId(idWorker.nextId() + "");
        enterpriseDao.save(enterprise);
    }

    @Override
    public Enterprise getEnterprise(String id) {
        return enterpriseDao.getOne(id);
    }

    @Override
    public Page<Enterprise> listEnterpriseByPage(int pageSize, int pageIndex, Enterprise enterprise) {
        Specification<Enterprise> specification = new Specification<Enterprise>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Enterprise> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>(5);
                if (StringUtils.isNotEmpty(enterprise.getName())) {
                    predicateList.add(cb.like(root.get("name").as(String.class), "%" + enterprise.getName() + "%"));
                }
                if (StringUtils.isNotEmpty(enterprise.getSummary())) {
                    predicateList.add(cb.like(root.get("summary").as(String.class), "%" + enterprise.getSummary() + "%"));
                }
                if (StringUtils.isNotEmpty(enterprise.getIshot())) {
                    predicateList.add(cb.equal(root.get("ishot").as(String.class), enterprise.getIshot()));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        PageRequest page = PageRequest.of(pageIndex - 1, pageSize);
        return enterpriseDao.findAll(specification, page);
    }

    @Override
    public long count(Enterprise enterprise) {
        Specification<Enterprise> specification = new Specification<Enterprise>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Enterprise> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>(5);
                if (StringUtils.isNotEmpty(enterprise.getName())) {
                    predicateList.add(cb.like(root.get("name").as(String.class), "%" + enterprise.getName() + "%"));
                }
                if (StringUtils.isNotEmpty(enterprise.getSummary())) {
                    predicateList.add(cb.like(root.get("summary").as(String.class), "%" + enterprise.getSummary() + "%"));
                }
                if (StringUtils.isNotEmpty(enterprise.getIshot())) {
                    predicateList.add(cb.equal(root.get("ishot").as(String.class), enterprise.getIshot()));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        return enterpriseDao.count(specification);
    }

    @Override
    public void delete(String id) {
        enterpriseDao.deleteById(id);
    }

    @Override
    public void update(Enterprise enterprise) {
        enterpriseDao.save(enterprise);
    }

    @Override
    public List<Enterprise> hotlist() {
        return enterpriseDao.findByIshot("1");
    }

}
