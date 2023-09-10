package com.jspiders.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.dto.Player;
import com.jspiders.manytoone.dto.Team;

public class PlayerDao {
	
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
		
		Team team = new Team();
		team.setId(4545);
		team.setName("Indian Cricket Team");
		team.setCountry("India");
		
		Player player1 = new Player();
		player1.setId(01);
		player1.setName("Rohit");
		player1.setAge(36);
		
		Player player2 = new Player();
		player2.setId(02);
		player2.setName("Virat");
		player2.setAge(32);
		
		player1.setTeam(team);
		player2.setTeam(team);
		
		entityManager.persist(team);
		entityManager.persist(player1);
		entityManager.persist(player2);
		
		entityTransaction.commit();
		closeConnection();
	}

 
}
