package com.jspiders.onetomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@Entity
public class College {
	
	@Id
	private int id;
	private String name;
	@OneToMany
	List<Teacher> teachers;

}
