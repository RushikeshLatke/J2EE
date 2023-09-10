package com.jspiders.onetomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.dto.College;
import com.jspiders.onetomany.dto.Teacher;

public class CollegeDao {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	private static EntityManager entityManager;
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("school");
		entityManager= entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		if (entityManagerFactory!=null) {
			
			entityManagerFactory.close();
			
		}
		if (entityManager!=null) {
			entityManager.close();
			
		}
		if (entityTransaction!=null) {
			
			if (entityTransaction.isActive()) {
				
				entityTransaction.rollback();
				
			}
			
		}
	}
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		College college = new College();
		college.setId(1515);
		college.setName("Jspm Rscoe");
	    
		Teacher teacher1 = new Teacher();
		teacher1.setId(01);
		teacher1.setName("Amar");
		teacher1.setSubject("SOM");
		
		Teacher teacher2 = new Teacher();
		teacher2.setId(02);
		teacher2.setName("Jitendra");
		teacher2.setSubject("Thermal");
		
		Teacher teacher3 = new Teacher();
		teacher3.setId(03);
		teacher3.setName("Dharmadhikari");
		teacher3.setSubject("Automobile");
		
		List<Teacher> teachers = new ArrayList<>();
		teachers.add(teacher1);
		teachers.add(teacher2);
		teachers.add(teacher3);
		
		college.setTeachers(teachers);
		
		entityManager.persist(college);
		entityManager.persist(teacher1);
		entityManager.persist(teacher2);
		entityManager.persist(teacher3);
		
		
		
		
		
		
		entityTransaction.commit();
		closeConnection();
	}

}
