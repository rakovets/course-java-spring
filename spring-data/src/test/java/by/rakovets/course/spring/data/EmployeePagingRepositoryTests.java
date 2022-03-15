package by.rakovets.course.spring.data;

import by.rakovets.course.spring.data.entity.Employee;
import by.rakovets.course.spring.data.repository.EmployeePagingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"/application-context.xml"})
public class EmployeePagingRepositoryTests {
    @Autowired
    private EmployeePagingRepository employeePagingRepository;

    @BeforeEach
    public void init() {
        Employee employee1 = new Employee(null, "Mat", "White", 21, null);
        Employee employee2 = new Employee(null, "Tom", "Black", 33, null);
        Employee employee3 = new Employee(null, "Jin", "Smith", 42, null);
        Employee employee4 = new Employee(null, "Alex", "Bush", 31, null);
        Employee employee5 = new Employee(null, "Greg", "Cook", 26, null);
        Employee employee6 = new Employee(null, "Jhon", "Grey", 72, null);
        employeePagingRepository.save(employee1);
        employeePagingRepository.save(employee2);
        employeePagingRepository.save(employee3);
        employeePagingRepository.save(employee4);
        employeePagingRepository.save(employee5);
        employeePagingRepository.save(employee6);
    }

    @Test
    public void pageableTest() {
        List<Long> ids = Stream.of(2L, 3L, 4L).collect(Collectors.toList());
        Page<Employee> employeesPage = employeePagingRepository.findByDepartmentIdIn(ids, PageRequest.of(1, 3, Sort.Direction.DESC, "age"));
        employeesPage.getContent().forEach(System.out::println);
        employeesPage = employeePagingRepository.findByFirstName("Sasha",
                PageRequest.of(0, 2, Sort.Direction.DESC, "age"));
        employeesPage.getContent().forEach(System.out::println);
        employeesPage = employeePagingRepository.findAll(PageRequest.of(0, 2, Sort.Direction.DESC, "age"));
        employeesPage.getContent().forEach(System.out::println);
        employeesPage = employeePagingRepository.findByDepartmentId(2L,
                PageRequest.of(0, 2, Sort.Direction.DESC, "age"));
        employeesPage.getContent().forEach(System.out::println);

        employeePagingRepository.findAll(Sort.by(Sort.Direction.DESC, "department.name"))
                .forEach(System.out::println);
    }
}
