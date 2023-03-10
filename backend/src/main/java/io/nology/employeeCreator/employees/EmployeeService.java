package io.nology.employeeCreator.employees;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.github.javafaker.Faker;

import io.nology.employeeCreator.seeder.EmployeeBuilder;
import io.nology.employeeCreator.seeder.EmployeeSeederDTO;
import jakarta.annotation.Nullable;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Employee createEmployee(EditEmployeeDTO data) throws Exception{
		if (!checkDate(data.getStartDate(), data.getFinishDate())) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Start date is after finish date");
		}
		Optional<Employee> existingEmailOptional = repository.findByEmail(data.getEmail());
		if (existingEmailOptional.isPresent()) {
			throw new IllegalArgumentException("Email is already used");
		}
		Employee newEmployee = new Employee(data.getFirstName(), data.getLastName(), data.getMiddleName(), data.getEmail(), data.getPhone(), data.getAddress()
				, data.isPermanent(), data.getStartDate(), data.getFinishDate(), data.isFullTime(), data.getHoursPerWeek());
		
		this.repository.save(newEmployee);
		return newEmployee;
		
	}
	
	public Employee editEmployee(EditEmployeeDTO data, long id) throws Exception{
		Optional<Employee> maybeEmployee = getEmployeeById(id);
		if (maybeEmployee.isEmpty()) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Employee Id does not exist");
		}
		Employee updatedEmployee = maybeEmployee.get();
		Optional<Employee> existingEmailOptional = repository.findByEmail(data.getEmail());
		if (existingEmailOptional.isPresent() && existingEmailOptional.get() != updatedEmployee) {
			throw new IllegalArgumentException("Email is already used");
		}
		if (!data.getFirstName().isEmpty() ) updatedEmployee.setFirstName(data.getFirstName());
		
		if (!data.getLastName().isEmpty()) updatedEmployee.setLastName(data.getLastName());
		
		if (!data.getMiddleName().isEmpty()) updatedEmployee.setMiddleName(data.getMiddleName());

		if (!data.getEmail().isEmpty()) updatedEmployee.setEmail(data.getEmail());
		
		
		if (!data.getPhone().isEmpty()) updatedEmployee.setPhone(data.getPhone());
		
		if (!data.getAddress().isEmpty()) updatedEmployee.setAddress(data.getAddress());
		
		if (data.getStartDate() != null && data.getFinishDate() != null) {
			if (!checkDate(data.getStartDate(), data.getFinishDate())) {
				throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Start date is after finish date");
			}
		} else if (data.getFinishDate() != null && checkDate(updatedEmployee.getStartDate(), data.getFinishDate())) {
			if (!checkDate(updatedEmployee.getStartDate(), data.getFinishDate())) {
				throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Start date is after finish date");
			}
		} else if (data.getStartDate() != null) {
			if(!checkDate(data.getStartDate(), updatedEmployee.getFinishDate())) {
				throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Start date is after finish date");
			}
		}
		if (!data.isPermanent().equals(null)) updatedEmployee.setPermanent(data.isPermanent());
		if (!data.isFullTime().equals(null)) updatedEmployee.setFullTime(data.isFullTime());
		if (!data.getHoursPerWeek().equals(null)) updatedEmployee.setHoursPerWeek(data.getHoursPerWeek());
		updatedEmployee.setFinishDate(data.getFinishDate());
		
		
		
		
		return this.repository.save(updatedEmployee);
	}
	
	public Optional<Employee> getEmployeeById(long id) {
		return this.repository.findById(id);
	}
	
	public Employee deleteEmployee(long id){
		Optional<Employee> employeeOptional = getEmployeeById(id);
		if (employeeOptional.isPresent()) {
			this.repository.delete(employeeOptional.get());
			return employeeOptional.get();
		}
		return null;
	}
	
	public List<Employee> getEmployees(){
		return this.repository.findAll();
	}
	

	private Boolean checkDate(LocalDate startDate, @Nullable LocalDate endDate) {
		if (endDate == null || endDate.isAfter(startDate)) {
			return true;
		}
		return false;
		
	}
	
	public void seedEmployee(EmployeeSeederDTO data) {
		int number = data.getNumber();
		Faker faker = new Faker();
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();
		for  (int i = 0; i < number; i++) {
			employeeBuilder.setFirstName(faker.name().firstName());
			employeeBuilder.setMiddleName(faker.name().firstName());
			employeeBuilder.setLastName(faker.name().lastName());
			employeeBuilder.setEmail(faker.bothify("????##@gmail.com"));
			employeeBuilder.setPhone(faker.phoneNumber().phoneNumber());
			employeeBuilder.setAddress(faker.address().streetAddress());
			employeeBuilder.setPermanent(true);
			employeeBuilder.setStartDate(LocalDate.now());
			employeeBuilder.setFinishDate(null);
			employeeBuilder.setHoursPerWeek(37.5);
			Employee newEmployee = employeeBuilder.createEmployee();
			this.repository.save(newEmployee);	
		}
	}
	
	
	

}
