package br.indra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = emf.createEntityManager();
		Automovel automovel = new Automovel();
		automovel.setAnodeFabricacao(2010);
		automovel.setAnoModelo(2010);
		automovel.setMarca("Citroen");
		automovel.setModelo("C3");
		automovel.setObservacoes("Manutenção cara");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(automovel);
		tx.commit();
		em.close();
		emf.close();
	}

}
