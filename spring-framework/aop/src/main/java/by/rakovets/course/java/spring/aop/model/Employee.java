package by.rakovets.course.java.spring.aop.model;

import by.rakovets.course.java.spring.aop.aspect.Loggable;

public class Employee {
	private String name;

	public String getName() {
		return name;
	}

	@Loggable
	public void setName(String nm) {
		this.name = nm;
	}

	public void throwException() {
		throw new RuntimeException("Фиктивное исключение");
	}
}
