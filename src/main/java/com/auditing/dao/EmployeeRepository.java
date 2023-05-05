package com.auditing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditing.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
