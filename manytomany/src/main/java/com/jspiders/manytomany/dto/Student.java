package com.jspiders.manytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
@Data
@Entity
public class Student {
	
	@Id
	int id;
	String name;
	String email;
	@ManyToMany
	List<Course> courses;
	
	

}
