package com.jspiders.onetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
@Data
@Entity
public class License {
	@Id
	private int id;
	private int licenceNo;
	private String expDate; 
	@OneToOne(mappedBy = "license")
	Driver driver;

}
