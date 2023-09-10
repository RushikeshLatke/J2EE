package com.jspiders.onetomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.dto.School;
import com.jspiders.onetomany.dto.Student;

public class SchoolDao {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("school");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
		
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
		
		School school = new School();
		school.setId(3247);
		school.setName("Kholeshwar High School");
        school.setAdress("Ambajogai");
        
        Student student1 = new Student();
        student1.setName("Vaibhav Lad");
        student1.setEmail("vaibhav@gmail.com");
        
        
        Student student2 = new Student();
        student2.setName("Deepak kolhe");
        student2.setEmail("deepak@gmail.com");
        
        Student student3 = new Student();
        student3.setName("Nikhil Maykar");
        student3.setEmail("nikhil@gmail.com");
        
        Student student4 = new Student();
        student4.setName("Amar Panchal");
        student4.setEmail("amar@gmail.com");
        
        Student student5 = new Student();
        student5.setName("Rushikesh Latke");
        student5.setEmail("rushikesh@gmail.com");
        
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        
        school.setStudents(students);
        
        entityManager.persist(school);
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);
        entityManager.persist(student5);
        
        
        
		entityTransaction.commit();
		closeConnection();
	}

}
