package com.auditing.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "emp_table")
public class Employee {

	@Id
	@GeneratedValue
	private int id;

	private String name;
	
	@JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date doj;
	
	private String dept;
	
	private double salary;
	
	//audit related fields 
	
	@CreatedDate
	private Date createDate;
	
	@LastModifiedDate
	private Date lastModifiedDate;
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedBy
	private String modifiedBy;
}
