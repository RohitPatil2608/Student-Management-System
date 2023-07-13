package com.jspiders.student_management_system.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="student_details")
public class StudentPOJO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="student_id")
	private int id;
	@Column(name="student_name")
	private String name;
	@Column(name="email_id")
	private String email;
	@Column(name="mobile_no")
	private long mobile;
	@Column(name="student_add")
	private String address;
}
