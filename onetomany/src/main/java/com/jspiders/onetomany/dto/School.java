package com.jspiders.onetomany.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "schoolinfo")
public class School {
	@Id
	@Column(name = "school_id")
	private int id;
	@Column(name = "school_Name")
	private String name;
	@Column(name = "student_Adress")
	private String adress;
	@OneToMany(cascade = CascadeType.PERSIST)
	List<Student> students;

}
