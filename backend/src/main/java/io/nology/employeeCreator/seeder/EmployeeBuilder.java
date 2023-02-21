package io.nology.employeeCreator.seeder;

import java.time.LocalDate;

import io.nology.employeeCreator.employees.Employee;

public class EmployeeBuilder {
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private boolean permanent;
	private LocalDate startDate;
	private LocalDate finishDate;
	private boolean fullTime;
	private Double hoursPerWeek;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}
	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}
	public void setHoursPerWeek(Double hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	
	public Employee createEmployee() {
		return new Employee(firstName, lastName, middleName, email, phone, address, permanent, startDate, finishDate, fullTime, hoursPerWeek);
	}
	
	
	

}
