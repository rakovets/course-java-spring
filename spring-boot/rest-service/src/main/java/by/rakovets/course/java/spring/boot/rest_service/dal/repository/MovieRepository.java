package by.rakovets.course.java.spring.boot.rest_service.dal.repository;

import by.rakovets.course.java.spring.boot.rest_service.dal.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
