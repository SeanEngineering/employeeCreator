package io.nology.employeeCreator.employees;

import java.time.LocalDate;
import java.util.Date;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Pattern;

public class EditEmployeeDTO {
	String firstName;
	String lastName;
	public Boolean isPermanent() {
		return permanent;
	}



	public Boolean isFullTime() {
		return fullTime;
	}



	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public String getMiddleName() {
		return middleName;
	}



	public String getEmail() {
		return email;
	}



	public String getPhone() {
		return phone;
	}



	public String getAddress() {
		return address;
	}





	public LocalDate getStartDate() {
		return startDate;
	}



	public LocalDate getFinishDate() {
		return finishDate;
	}





	public Short getHoursPerWeek() {
		return hoursPerWeek;
	}


	
	String middleName;
	String email;
	String phone;
	String address;
	Boolean permanent;
	LocalDate startDate;
	LocalDate finishDate;
	Boolean fullTime;
	Short hoursPerWeek;
	
	public EditEmployeeDTO() {}
	
	public EditEmployeeDTO(String firstName, String lastName, @Nullable String middleName,
			String email, String phone, String address, Boolean permanent,
			LocalDate startDate, LocalDate finishDate, Boolean fullTime, Short hoursPerWeek) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.email = email;
		this.address = address;
		this.permanent = permanent;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.fullTime = fullTime;
		this.hoursPerWeek = hoursPerWeek;
	}

}
