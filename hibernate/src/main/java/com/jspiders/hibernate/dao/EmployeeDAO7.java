package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmployeeDAO7 {
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
		
		Query query = entityManager.createQuery("DELETE  FROM EmployeeDTO emp WHERE id=4");
		
		int res= query.executeUpdate();
		
		System.out.println(res+" rows affected.");
		
		entityTransaction.commit();
		closeConnection();
	}

}
