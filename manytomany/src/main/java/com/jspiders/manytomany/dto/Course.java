package com.jspiders.manytomany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Course {
     @Id
	 int id;
	 String name;
     String fee;
}
