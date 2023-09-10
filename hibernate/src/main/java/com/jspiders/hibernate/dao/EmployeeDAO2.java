package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.EmployeeDTO;

public class EmployeeDAO2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("employee");
		entityManager=entityManagerFactory.createEntityManager();
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
		
		EmployeeDTO emp=new EmployeeDTO();
		
		emp.setId(2);
		emp.setName("Ramesh");
		emp.setContact(738568489);
		emp.setEmail("ramesh@gmail.com");
		emp.setAdress("Pune");
		
		entityManager.persist(emp);
		
        EmployeeDTO emp2=new EmployeeDTO();
		
		emp2.setId(3);
		emp2.setName("Suresh");
		emp2.setContact(738585478);
		emp2.setEmail("suresh@gmail.com");
		emp2.setAdress("Mumbai");
		
		entityManager.persist(emp2);
		
		entityTransaction.commit();
		closeConnection();
	}

}
