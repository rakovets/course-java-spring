package by.rakovets.course.java.spring.boot.rest_service.service;

import by.rakovets.course.java.spring.boot.rest_service.dal.entity.Movie;

public interface MovieService {
    Movie save(Movie movie);

    Movie findOne(Long id);
}
