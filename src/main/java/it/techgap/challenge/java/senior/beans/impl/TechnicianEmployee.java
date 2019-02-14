package it.techgap.challenge.java.senior.beans.impl;

import it.techgap.challenge.java.senior.beans.Employee;

public class TechnicianEmployee implements Employee {

	/**
	 * Employee's starting salary
	 */
	private int startingSalary;
	/**
	 * Employees's name
	 */
	private String name;
	
	public TechnicianEmployee(String name, int startingSalary) {
		super();
		this.startingSalary = startingSalary;
		this.name = name;
	}

	@Override
	public double getSalary() {
		return startingSalary;
	}

	@Override
	public String getName() {
		return name;
	}
}
