package by.rakovets.course.spring.data;

import by.rakovets.course.spring.data.entity.Department;
import by.rakovets.course.spring.data.entity.Employee;
import by.rakovets.course.spring.data.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"/application-context.xml"})
public class DepartmentRepositoryTests {
    @Autowired
    private DepartmentRepository departmentRepository;

    @BeforeEach
    public void init() {
        Employee employee1 = new Employee(null, "Mat", "White", 21, null);
        Employee employee2 = new Employee(null, "Tom", "Black", 33, null);
        Employee employee3 = new Employee(null, "Jin", "Smith", 42, null);
        Employee employee4 = new Employee(null, "Alex", "Bush", 31, null);
        Employee employee5 = new Employee(null, "Greg", "Cook", 26, null);
        Employee employee6 = new Employee(null, "Jhon", "Grey", 72, null);
        Department department1 = new Department(null, "R&D", List.of(employee1, employee2, employee3));
        Department department2 = new Department(null, "Support", List.of(employee4, employee5, employee6));
        employee1.setDepartment(department1);
        employee2.setDepartment(department1);
        employee3.setDepartment(department1);
        employee4.setDepartment(department2);
        employee5.setDepartment(department2);
        employee6.setDepartment(department2);
        departmentRepository.save(department1);
        departmentRepository.save(department2);
    }

    @Test
    public void queryTest() {
        List<Department> departments = departmentRepository.getByJoinCondition("Alex");
        departments.forEach(System.out::println);
    }

    @Test
    public void maxAgeTest() {
        departmentRepository.getByMaxAge().forEach(System.out::println);
    }

    @Test
    public void queryParamTest() {
        departmentRepository.getByEmployeesLastName("Grey").forEach(System.out::println);
    }

    @Test
    public void nativeQueryTest() {
        departmentRepository.getByJoinConditionNative("Tom").forEach(System.out::println);
    }

    @Test
    public void findByExampleTest() {
        System.out.println(departmentRepository.findAll(
                Example.of(new Department(null, "Support", null))));
        List<Department> departments = departmentRepository.findAll(
                Example.of(
                        new Department(null, "port", null),
                        ExampleMatcher.matching()
                                .withIgnoreCase()
                                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                )
        );
        departments.forEach(System.out::print);
    }
}
