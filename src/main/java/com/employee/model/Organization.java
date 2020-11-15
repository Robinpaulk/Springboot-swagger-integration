package com.employee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Organization {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int companyId;
	private String companyName;
	private String location;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="organization_id",referencedColumnName="companyId")
	private List<Employee> employee;

	public Organization() {
		
	}

	public Organization(int companyId, String companyName, String location, List<Employee> employee) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.location = location;
		this.employee = employee;
	}

	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}


	public List<Employee> getEmployee() {
		return employee;
	}


	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
   
}
