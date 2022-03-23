package by.rakovets.course.java.spring.security.dal.dao;


import by.rakovets.course.java.spring.security.dal.dao.common.BaseDao;
import by.rakovets.course.java.spring.security.dal.entity.User;

public interface UserDao extends BaseDao<User> {
    User findByName(String name);
}
