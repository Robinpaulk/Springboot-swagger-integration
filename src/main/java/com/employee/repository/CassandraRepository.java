package com.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.model.EmployeeCassandra;

public interface CassandraRepository extends CrudRepository<EmployeeCassandra, Integer>{

}
