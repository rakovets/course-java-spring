package by.rakovets.course.java.spring.orm.service;

import by.rakovets.course.java.spring.orm.dal.dao.KnightDao;
import by.rakovets.course.java.spring.orm.dal.entity.Knight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KnightServiceImpl implements KnightService {
    private final KnightDao knightDao;

    @Autowired
    public KnightServiceImpl(KnightDao knightDao) {
        this.knightDao = knightDao;
    }

    @Override
    public Knight findByName(String name) {
        save(new Knight());
        return knightDao.findByName(name);
    }

    @Override
    public void save(Knight knight) {
        knightDao.save(knight);
    }
}
