package by.rakovets.course.java.spring.orm.dal.dao;

import by.rakovets.course.java.spring.orm.dal.dao.common.BaseDaoImpl;
import by.rakovets.course.java.spring.orm.dal.entity.Knight;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KnightDaoImpl extends BaseDaoImpl<Knight> implements KnightDao {
    @Override
    public Knight findByName(String name) {
        List<Knight> knightList = getSessionFactory().getCurrentSession().createQuery(
                "select k from Knight k where k.name=:name", Knight.class)
                .setParameter("name", name)
                .getResultList();
        return knightList.size() > 0 ? knightList.get(0) : null;
    }
}
