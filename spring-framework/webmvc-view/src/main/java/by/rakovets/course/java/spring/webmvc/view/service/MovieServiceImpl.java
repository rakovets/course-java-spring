package by.rakovets.course.java.spring.webmvc.view.service;

import by.rakovets.course.java.spring.webmvc.view.dal.dao.MovieDao;
import by.rakovets.course.java.spring.webmvc.view.dal.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Long save(Movie movie) {
        movieDao.save(movie);
        return movie.getId();
    }

    @Override
    public Movie findById(Long movieId) {
        return movieDao.findOne(movieId);
    }
}
