package io.nology.employeeCreator.employees;

import java.time.LocalDate;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {
	
	public Employee() {};
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column
	String firstName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}


	public Short getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(Short hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public boolean isFullTime() {
		return fullTime;
	}

	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	@Nullable
	 String middleName;
	
	@Column
	 String lastName;
	
	@Column
	 String email;
	
	@Column
	 String phone;
	
	@Column
	 String address;
	
	@Column
	 boolean permanent;
	
	@Column
	 LocalDate startDate;
	
	@Column
	@Nullable
	 LocalDate finishDate;
	
	@Column
	 boolean fullTime;
	
	@Column
	 Short hoursPerWeek;
	
	public Employee(String firstName, String lastName, String middleName, String email,
			String phone, String address, boolean permanent, LocalDate startDate,
			LocalDate finishDate, boolean fullTime, Short hoursPerWeek) {
		this.firstName = firstName;
		this.lastName =lastName;
		this.middleName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.permanent = permanent;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.fullTime = fullTime;
		this.hoursPerWeek = hoursPerWeek;
		
	}
	

}
