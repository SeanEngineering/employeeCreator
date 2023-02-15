package io.nology.employeeCreator.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> employees = this.service.getEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		
	}
	
	@PostMapping 
	ResponseEntity<Employee> postEmployee(@Valid @RequestBody EditEmployeeDTO data) throws Exception{
		Employee employee = this.service.createEmployee(data);
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/{id}") 
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody EditEmployeeDTO data, @PathVariable long id) throws Exception {
		Employee updatedEmployee = this.service.editEmployee(data, id);
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
		Employee employee = this.service.deleteEmployee(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
	}
	

}
