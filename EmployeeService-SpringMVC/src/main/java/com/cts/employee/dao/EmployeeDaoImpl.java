package com.cts.employee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Repository;

import com.cts.employee.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sf;
	
	public void saveEmployee(Employee emp) {
		sf.getCurrentSession().save(emp);
		System.out.println("Saved");
	}

	public List<Employee> listEmployee() {
		
		List<Employee> employeeList = sf.getCurrentSession().createQuery("from Employee").list();
		System.out.println(employeeList.size());
		return employeeList;
	}
}
