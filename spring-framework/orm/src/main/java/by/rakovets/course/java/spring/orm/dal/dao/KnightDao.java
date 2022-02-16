package by.rakovets.course.java.spring.orm.dal.dao;

import by.rakovets.course.java.spring.orm.dal.dao.common.BaseDao;
import by.rakovets.course.java.spring.orm.dal.entity.Knight;

public interface KnightDao extends BaseDao<Knight> {
    Knight findByName(String name);
}
