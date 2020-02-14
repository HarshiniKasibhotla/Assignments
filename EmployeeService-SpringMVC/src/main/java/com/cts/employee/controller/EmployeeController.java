package com.cts.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.employee.entity.Employee;
import com.cts.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	
	@Autowired
	private EmployeeService es;
	
	@RequestMapping("/")
	public String welcome() {
		return "index";
	}
	
	
	
	// load employee dform 
	
	@RequestMapping("loadForm")
	public String loadForm() {
		return "employeeform";
	}
	

	
	@RequestMapping("saveEmployee")
	public void saveEmployee(@ModelAttribute Employee emp) {
		
		
	
		es.saveEmployee(emp);
		
		
		
	}
	
	@RequestMapping(value = "listEmployees")
	public String listEmployees(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployees", es.listEmployee());
		return "employeeList";
	}
	
	
	
	
	
}
