package by.rakovets.course.spring.data.repository;

import by.rakovets.course.spring.data.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeePagingRepository extends PagingAndSortingRepository<Employee, Long> {
    Page<Employee> findByDepartmentIdIn(List<Long> ids, Pageable pageable);
    Page<Employee> findByDepartmentId(Long id, Pageable pageable);
    Page<Employee> findByFirstName(String name, Pageable pageable);
}
