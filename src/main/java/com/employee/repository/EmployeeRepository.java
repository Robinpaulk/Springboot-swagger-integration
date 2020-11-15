package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT t from Employee t WHERE t.email= ?1")
	List<Employee> findByEmail(String email);
}
