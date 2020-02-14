package com.cts.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.employee.dao.EmployeeDao;
import com.cts.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeDao empDao;
	
	
	@Transactional
	public void saveEmployee(Employee emp) {
		empDao.saveEmployee(emp);
	}
	
	

	@Transactional
	public List<Employee> listEmployee() {
		return empDao.listEmployee();
	}



	
	
}




