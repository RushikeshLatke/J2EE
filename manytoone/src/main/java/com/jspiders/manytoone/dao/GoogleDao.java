package com.jspiders.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.dto.Google;
import com.jspiders.manytoone.dto.SoftwareDeveloper;

public class GoogleDao {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("player");
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
		
		Google google = new Google();
		google.setId(1717);
		google.setName("Google");
		google.setLocation("USA");
		
		SoftwareDeveloper softwareDeveloper1	= new SoftwareDeveloper();
		softwareDeveloper1.setId(01);
		softwareDeveloper1.setName("Jack");
		softwareDeveloper1.setJobRole("Junior Developer");
		
		SoftwareDeveloper softwareDeveloper2	= new SoftwareDeveloper();
		softwareDeveloper2.setId(02);
		softwareDeveloper2.setName("Roma");
		softwareDeveloper2.setJobRole("Senior Developer");
		
		softwareDeveloper1.setGoogle(google);
		softwareDeveloper2.setGoogle(google);
		
		entityManager.persist(google);
		entityManager.persist(softwareDeveloper1);
		entityManager.persist(softwareDeveloper2);
		
		
		
		entityTransaction.commit();
		closeConnection();
	}

}
