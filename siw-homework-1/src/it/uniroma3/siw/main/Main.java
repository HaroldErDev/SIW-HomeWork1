package it.uniroma3.siw.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hw1-unit");
		EntityManager em = emf.createEntityManager();		
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		tx.commit();
		
		em.close();
		emf.close();
	}
}
