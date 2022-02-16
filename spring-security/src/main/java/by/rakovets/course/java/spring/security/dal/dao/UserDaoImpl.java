package by.rakovets.course.java.spring.security.dal.dao;

import by.rakovets.course.java.spring.security.dal.dao.common.BaseDaoImpl;
import by.rakovets.course.java.spring.security.dal.entity.SystemUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<SystemUser> implements UserDao {

    @Override
    public SystemUser findByName(String name) {
        List<SystemUser> systemUserList = getCurrentSession()
                .createQuery("select u from SystemUser u where u.name=:name", SystemUser.class)
                .setParameter("name", name)
                .getResultList();
        return systemUserList.size() > 0 ? systemUserList.get(0) : null;
    }
}
