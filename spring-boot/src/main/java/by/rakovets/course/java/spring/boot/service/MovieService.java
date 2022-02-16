package by.rakovets.course.java.spring.boot.service;

import by.rakovets.course.java.spring.boot.dal.entity.Movie;

public interface MovieService {
    Movie save(Movie movie);

    Movie findOne(Long id);
}
