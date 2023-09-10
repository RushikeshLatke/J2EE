package com.jspiders.manytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Person {
	
	@Id
	private int id;
	private String name;
	@ManyToMany
	List<Vehicle> vehicles;

}
