package com.hazkassb.zgigi.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Customer {
	
	@Id
	private Integer Id;
	private String name;
	private String department;
	private String updatedBy;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date UpdatedOn;
	
	public Customer() {
		
	}

	public Customer(Integer id, String name, String department, String updatedBy, Date updatedOn) {
		super();
		Id = id;
		this.name = name;
		this.department = department;
		this.updatedBy = updatedBy;
		UpdatedOn = updatedOn;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		UpdatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", name=" + name + ", department=" + department + ", updatedBy=" + updatedBy
				+ ", UpdatedOn=" + UpdatedOn + "]";
	}
	
	
	

}
