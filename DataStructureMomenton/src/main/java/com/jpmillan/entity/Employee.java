package com.jpmillan.entity;

import java.io.Serializable;

public class Employee implements Serializable{

private static final long serialVersionUID = 1L;
	
	public Employee(String employee_name, String id, String manager_id) {
		this.employee_name = employee_name;
		this.id = id;
		this.manager_id = manager_id;
	}
	
	private String employee_name;
	private String id;
	private String manager_id;
	
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

}
