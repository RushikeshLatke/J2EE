package com.jspiders.onetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Driver {
	
	@Id
	private int id;
	private String name;
	private int age;
	private long contact;
	@OneToOne
	@JoinColumn
	License license;
	

}
