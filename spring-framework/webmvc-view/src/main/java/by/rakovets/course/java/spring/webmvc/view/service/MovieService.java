package by.rakovets.course.java.spring.webmvc.view.service;

import by.rakovets.course.java.spring.webmvc.view.dal.entity.Movie;

public interface MovieService {
    Long save(Movie movie);

    Movie findById(Long movieId);
}
