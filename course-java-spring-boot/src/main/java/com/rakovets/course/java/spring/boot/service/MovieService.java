package com.rakovets.course.java.spring.boot.service;

import com.rakovets.course.java.spring.boot.dal.entity.Movie;

public interface MovieService {
    Movie save(Movie movie);

    Movie findOne(Long id);
}
