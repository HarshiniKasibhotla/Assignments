package com.cts.employee.service;

import java.util.List;

import com.cts.employee.entity.Employee;

public interface EmployeeService {

	void saveEmployee(Employee emp);
	
	List<Employee> listEmployee();

}