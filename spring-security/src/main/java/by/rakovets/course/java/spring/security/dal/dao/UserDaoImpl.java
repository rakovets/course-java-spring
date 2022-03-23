package by.rakovets.course.java.spring.security.dal.dao;

import by.rakovets.course.java.spring.security.dal.dao.common.BaseDaoImpl;
import by.rakovets.course.java.spring.security.dal.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User findByName(String name) {
        List<User> userList = getCurrentSession()
                .createQuery("select u from User u where u.name=:name", User.class)
                .setParameter("name", name)
                .getResultList();
        return userList.size() > 0 ? userList.get(0) : null;
    }
}
