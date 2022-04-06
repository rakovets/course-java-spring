package by.rakovets.course.java.spring.aop.service;

import by.rakovets.course.java.spring.aop.model.Employee;

public class EmployeeService {
	private Employee employee;

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee e) {
		this.employee = e;
	}
}
