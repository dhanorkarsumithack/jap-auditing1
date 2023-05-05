package com.auditing.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auditing.dao.EmployeeRepository;
import com.auditing.dto.InputRequest;
import com.auditing.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public String saveEmployee(InputRequest< Employee> request) {
		
		String currentUser = request.getLoggedInUser();
		request.setTimezone(Calendar.getInstance().getTimeZone().getDisplayName());
		Employee employee = request.getEmployee();
		employee.setCreatedBy(currentUser);
		employeeRepository.save(employee);
		return "Employee saved successfullly...";
	}
	
	public String updateEmployee(int id, double salary,InputRequest<Employee> request) {
		
		Employee emp=employeeRepository.findById(id).get();
		
		if(emp!=null) {
			emp.setSalary(salary);
			emp.setModifiedBy(request.getLoggedInUser());
		    employeeRepository.save(emp);
		}else {
			throw new RuntimeException("Employee not find with id"+id);
		}
		
		return "Employee updated successfully";
	}
	
}
