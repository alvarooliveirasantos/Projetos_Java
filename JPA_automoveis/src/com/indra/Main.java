package com.indra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
	
		try{
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();
		}
		catch(Exception e){
		System.out.println("erro ao conectar" );
		}
		/*
		Automovel automovel = new Automovel();
		automovel.setAnodeFabricacao(2010);
		automovel.setAnoModelo(2010);
		automovel.setMarca("Citroen");
		automovel.setModelo("C3");
		automovel.setObservacoes("Manutenção cara");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(automovel);
		System.out.println("OK");
		tx.commit();
		em.close();
		emf.close();
	*/
			}
	}
