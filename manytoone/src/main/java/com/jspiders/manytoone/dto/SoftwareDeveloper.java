package com.jspiders.manytoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class SoftwareDeveloper {
	
	@Id
	private int id;
	private String name;
	private String jobRole;
	@ManyToOne
	private Google google;
	
}
