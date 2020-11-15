package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.model.EmployeeCassandra;
import com.employee.model.Organization;
import com.employee.repository.CassandraRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.OrganizationRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private CassandraRepository cassandraRepo;
	@Autowired
	private OrganizationRepository orgRepo;
	
	public List<Employee> getAllEmployee(){
        return empRepo.findAll();
    }
	
   
	
    public Employee getEmployee(int id){
        return empRepo.findById(id).orElse(null);
    }
    
    public Employee addEmployee(Employee employee){
       
         empRepo.save(employee);
         
         EmployeeCassandra employees = new EmployeeCassandra();
         employees.setId(employee.getId());
         employees.setFirstName(employee.getFirstName());
         employees.setLastName(employee.getLastName());
         employees.setEmail(employee.getEmail());
         
         cassandraRepo.save(employees);
         return employee;
    }
    
   
    public void deleteEmployee(int id){
    	empRepo.deleteById(id);
    	cassandraRepo.deleteById(id);
    }


	public Employee UpdateEmployee(Employee employee, int id) {
		System.out.println("inside update");
		
		Optional<Employee> empSql = empRepo.findById(id);
		if(!empSql.isPresent()) {
			empRepo.save(employee);
		} else {
			Employee emp = empSql.get();
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setEmail(employee.getEmail());
			empRepo.save(emp);
		}
	   Optional<EmployeeCassandra> empCassandra =cassandraRepo.findById(id);
	   if(empCassandra.isPresent()) {
		   EmployeeCassandra emp1 = empCassandra.get();
		   emp1.setFirstName(employee.getFirstName());
		   emp1.setLastName(employee.getLastName());
		   emp1.setEmail(employee.getEmail());
		   cassandraRepo.save(emp1);
	   }
	   else {
		   EmployeeCassandra emp2 = new EmployeeCassandra();
		   emp2.setId(employee.getId());
		   emp2.setEmail(employee.getEmail());
		   emp2.setFirstName(employee.getFirstName());
		   emp2.setLastName(employee.getLastName());
		   cassandraRepo.save(emp2);
	   }
		
		return employee;
	}

	public List<Employee> getEmployeeBasedEmail(Employee employee) {
		
		return empRepo.findByEmail(employee.getEmail());
	}

	@Override
	public List<Organization> getAllEmployesOrganization(int companyId) {
		return orgRepo.findAll();
	}
	
	@Override
	public Organization createEmployee(Organization organization) {
		
		return orgRepo.save(organization);
	}



	public List<Organization> listOrganization(int companyId) {
		return orgRepo.findAll();
	}



	public Organization updateOrganization(int companyId, Organization organization) {
		
		Optional<Organization> orgOptional = orgRepo.findById(companyId);
		if(!orgOptional.isPresent()) {
			return orgRepo.save(organization);
		}else {
			Organization org = orgOptional.get();
			org.setCompanyId(companyId);
			org.setCompanyName(organization.getCompanyName());
			org.setLocation(organization.getLocation());
			org.setEmployee(organization.getEmployee());
			return orgRepo.save(org);
		}
		
	}



	public void deleteOrganization(int companyId) {
		 orgRepo.deleteById(companyId);
	}






	
}
