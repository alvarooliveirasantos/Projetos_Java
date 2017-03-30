package com.indra;
import java.util.List;

import javax.persistence.EntityManager;

public class JPAAutomovelDAO implements AutomovelDao {

	@Override
	public void salva(Automovel a) {
		EntityManager em = abreconexao();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	

	@Override
	public List<Automovel> lista() {
		EntityManager em = abreconexao();
		List<Automovel> automoveis = em.createQuery("select * from Automovel a").getResultList();
		em.close();
		return automoveis;
	}

}

