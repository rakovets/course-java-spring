package by.rakovets.course.java.spring.security.dal.dao;


import by.rakovets.course.java.spring.security.dal.dao.common.BaseDao;
import by.rakovets.course.java.spring.security.dal.entity.SystemUser;

public interface UserDao extends BaseDao<SystemUser> {
    SystemUser findByName(String name);
}
