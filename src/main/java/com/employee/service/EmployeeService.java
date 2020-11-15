package com.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee.model.Employee;
import com.employee.model.Organization;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployee(int id);
	
	public Employee addEmployee(Employee employee);
	
	public void deleteEmployee(int id);
	
	public Employee UpdateEmployee(Employee employee, int id);
	
	public List<Employee> getEmployeeBasedEmail(Employee employee);

	 public Organization createEmployee(Organization organization);
	 
	 public List<Organization> listOrganization(int companyId);
	 
	 public Organization updateOrganization(int companyId, Organization organization);
	 
	 public void deleteOrganization(int companyId);
	 
	 public List<Organization> getAllEmployesOrganization(int companyId);
}
