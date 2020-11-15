package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.model.EmployeeCassandra;
import com.employee.model.Organization;
import com.employee.repository.CassandraRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empService;

	@GetMapping
	public List<Employee> getEmployees() {
		return empService.getAllEmployee();
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@RequestParam int id) {
		return empService.getEmployee(id);
	}

//	 @PostMapping("/employeename")
//	 public List<Employee> getAllEmployeeBasedEmail(@RequestBody Employee employee) {
//		 return empService.getEmployeeBasedEmail(employee);
//	 }

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {

		return empService.addEmployee(employee);
	}

	@PostMapping("/listAllEmployee")
	public ResponseEntity<Employee> saveOrganization(@RequestBody List<Employee> employee) {
		System.out.println(employee.get(1));
		return null;
	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		return empService.UpdateEmployee(employee, id);

	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable(value = "id") int id) {
		empService.deleteEmployee(id);
	}

	@PostMapping("/organization/create")
	public Organization createOrganization(@RequestBody Organization organization) {

		return empService.createEmployee(organization);

	}
	
	@GetMapping("/organization/{id}")
	public List<Organization> listorganization(@PathVariable("id") int companyId){
		
		return empService.listOrganization(companyId);
	}
	
	@PutMapping("/organization/{id}")
	public Organization updateOrganization(@PathVariable("id") int companyId, @RequestBody Organization organization) {
		
		return empService.updateOrganization(companyId, organization);
	}

	@GetMapping("getAllEmployees/{id}")
	public ResponseEntity<List<Organization>> getAllEmployesOrganization(@PathVariable(name = "id") int companyId) {
		return new ResponseEntity<>(empService.getAllEmployesOrganization(companyId), HttpStatus.OK);
	}
	
	@DeleteMapping("/organization/{id}")
	public void deleteOrganization(@PathVariable("id") int companyId) {
		 empService.deleteOrganization(companyId);
	}
	
	
}
