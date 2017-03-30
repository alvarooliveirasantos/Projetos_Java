package br.indra;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateAutomovelDAO implements AutomovelDao {

	@Override
	public void salva(Automovel a) {
		Session s = abreconexao();
		Transaction tx = s.beginTransaction();
		s.save(a);
		tx.commit();
		s.close();

	}

	@Override
	public List<Automovel> lista() {
		Session s = abreconexao();
		List<Automovel> automoveis = s.createQuery("from * Automovel").list();
		s.close();
		return automoveis;

		return null;
	}

}
