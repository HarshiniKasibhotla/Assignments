package com.cts.employee.dao;

import java.util.List;

import com.cts.employee.entity.Employee;

public interface EmployeeDao {

	void saveEmployee(Employee emp);
	
	List<Employee> listEmployee();

}