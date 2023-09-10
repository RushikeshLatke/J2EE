package com.jspiders.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone.dto.Driver;
import com.jspiders.onetoone.dto.License;

public class DriverDao {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("person");
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
		
		Driver driver = new Driver();
		
		driver.setId(01);
		driver.setName("Surendar");
		driver.setAge(41);
		driver.setContact(738585488);
		
		License license = new License();
		license.setId(11);
		license.setLicenceNo(7878);
		license.setExpDate("01/08/1920");
		
		
		driver.setLicense(license);
		license.setDriver(driver);
		
		entityManager.persist(license);
		entityManager.persist(driver);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	

}
