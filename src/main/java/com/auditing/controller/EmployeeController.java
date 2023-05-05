package com.auditing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auditing.dto.InputRequest;
import com.auditing.model.Employee;
import com.auditing.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestBody InputRequest<Employee> request) {
		return employeeService.saveEmployee(request);
	}
	
	@PutMapping("/updateEmployee/{id}/{salary}")
	public String updateEmployee(@PathVariable int id, @PathVariable int salary, @RequestBody InputRequest< Employee> request) {
		return employeeService.updateEmployee(id, salary, request);
	}
	
}
