package com.jspiders.onetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AdharCard {
	
@Id	
private int id;
private long adharnumber;
private String dateOfIssue;



	

}
