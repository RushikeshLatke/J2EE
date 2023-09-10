package com.jspiders.manytomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomany.dto.Person;
import com.jspiders.manytomany.dto.Vehicle;

public class PersonDao {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("student");
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
		
		Person person1 = new Person();
		person1.setId(01);
		person1.setName("Krishna");
		
		Person person2 = new Person();
		person2.setId(02);
		person2.setName("Arjun");
		
		Vehicle vehicle1 = new  Vehicle();
		vehicle1.setId(11);
		vehicle1.setName("Car");
		
		Vehicle vehicle2 = new  Vehicle();
		vehicle2.setId(22);
		vehicle2.setName("Bike");
		
		List<Vehicle> vehicles1 = new ArrayList<>();
		vehicles1.add(vehicle1);
		
		List<Vehicle> vehicles2 = new ArrayList<>();
		vehicles2.add(vehicle1);
		vehicles2.add(vehicle2);
		
		
		
		person1.setVehicles(vehicles2);
		person2.setVehicles(vehicles1);
		
		
		
		
		
		entityTransaction.commit();
		closeConnection();
	}

}
