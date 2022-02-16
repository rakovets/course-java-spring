package by.rakovets.course.java.spring.boot.dal.repository;

import by.rakovets.course.java.spring.boot.dal.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
