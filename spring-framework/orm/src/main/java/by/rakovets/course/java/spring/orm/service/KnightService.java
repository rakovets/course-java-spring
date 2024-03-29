package by.rakovets.course.java.spring.orm.service;

import by.rakovets.course.java.spring.orm.dal.entity.Knight;

public interface KnightService {
    Knight findByName(String name);

    void save(Knight knight);
}
