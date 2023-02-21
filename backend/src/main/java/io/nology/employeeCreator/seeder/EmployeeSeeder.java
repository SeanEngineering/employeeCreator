package io.nology.employeeCreator.seeder;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import io.nology.employeeCreator.employees.Employee;
import io.nology.employeeCreator.employees.EmployeeRepository;

@Service
public class EmployeeSeeder {
	
	@Autowired
	private EmployeeRepository repository;

		
	public void seedEmployees(int number) {
		Faker faker = new Faker();
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();
		for  (int i = 0; i < number; i++) {
			employeeBuilder.setFirstName(faker.name().firstName());
			employeeBuilder.setMiddleName(faker.name().firstName());
			employeeBuilder.setLastName(faker.name().lastName());
			employeeBuilder.setEmail(faker.bothify("????##@gmail.com"));
			employeeBuilder.setPhone(faker.phoneNumber().toString());
			employeeBuilder.setAddress(faker.address().toString());
			employeeBuilder.setPermanent(true);
			employeeBuilder.setStartDate(LocalDate.now());
			employeeBuilder.setFinishDate(null);
			employeeBuilder.setHoursPerWeek(40.0);
			Employee newEmployee = employeeBuilder.createEmployee();
			this.repository.save(newEmployee);	
		}
		
	}
	
	
}
