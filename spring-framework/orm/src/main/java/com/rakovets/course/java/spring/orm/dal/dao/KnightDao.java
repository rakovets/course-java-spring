package com.rakovets.course.java.spring.orm.dal.dao;

import com.rakovets.course.java.spring.orm.dal.dao.common.BaseDao;
import com.rakovets.course.java.spring.orm.dal.entity.Knight;

public interface KnightDao extends BaseDao<Knight> {
    Knight findByName(String name);
}
