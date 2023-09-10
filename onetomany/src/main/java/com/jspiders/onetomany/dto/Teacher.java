package com.jspiders.onetomany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Teacher {
	
	@Id
	private  int id;
	private  String name;
	private  String subject;
	
}
