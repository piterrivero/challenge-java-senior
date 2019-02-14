package it.techgap.challenge.java.senior.beans.impl;

import it.techgap.challenge.java.senior.beans.Employee;

public class SalesmanEmployee implements Employee {

	/**
	 * Employee's starting salary
	 */
	private int startingSalary;
	/**
	 * Salesman monthly sales
	 */
	private int monthlySales;
	/**
	 * Employees's name
	 */
	private String name;
	
	public SalesmanEmployee(String name, int startingSalary, int monthlySales) {
		super();
		this.startingSalary = startingSalary;
		this.name = name;
		this.monthlySales = monthlySales;
	}

	@Override
	public double getSalary() {
		double salary = startingSalary + (monthlySales * 0.10);
		return salary;
	}

	@Override
	public String getName() {
		return name;
	}

}
