package it.techgap.challenge.java.senior.beans.impl;

import java.util.ArrayList;
import java.util.List;

import it.techgap.challenge.java.senior.beans.Employee;

public class ManagerEmployee implements Employee {

	/**
	 * Employee's starting salary
	 */
	private int startingSalary;
	/**
	 * Employees's name
	 */
	private String name;
	/**
	 * Employees's subordinates
	 */
	private Employee[] directSubordinates;
	private double totSubSalaries;
	private List<Double> temp;
	private int cont;
	private double managerSalary;
	
	public ManagerEmployee(String name, int startingSalary, Employee... directSubordinates) {
		super();
		this.startingSalary = startingSalary;
		this.name = name;
		this.directSubordinates = directSubordinates;
	}

	@Override
	public double getSalary() {
		temp = new ArrayList<>();
		calcSalary(this);
		return managerSalary;
	}
	
	private void calcSalary(Employee emp) {
		if (emp instanceof ManagerEmployee) {
			for (Employee sub : ((ManagerEmployee) emp).getDirectSubordinates()) {
				calcSalary(sub);
			}
			cont = 0;
			numberOfSubs(emp);
			int numberOfSubs = cont - 1 ;
			double subTotManager = 0;
			for (int i=0; i<numberOfSubs;i++){
				int nextPosition = temp.size()-(numberOfSubs-i);
				subTotManager = subTotManager + temp.get(nextPosition);
			}
			managerSalary = ((ManagerEmployee) emp).getStartingSalary() + (subTotManager * 0.005);
			totSubSalaries = totSubSalaries + managerSalary;
			temp.add(managerSalary);
		}else {
			totSubSalaries = totSubSalaries + emp.getSalary();
			temp.add(emp.getSalary());
		}
	}
	
	private void numberOfSubs(Employee emp) {
		if (emp instanceof ManagerEmployee) {
			for (Employee sub : ((ManagerEmployee) emp).getDirectSubordinates()) {
				numberOfSubs(sub);
			}
			cont++;
		}else {
			cont++;
		}
	}

	@Override
	public String getName() {
		return name;
	}

	public Employee[] getDirectSubordinates() {
		return directSubordinates;
	}

	public int getStartingSalary() {
		return startingSalary;
	}
}
