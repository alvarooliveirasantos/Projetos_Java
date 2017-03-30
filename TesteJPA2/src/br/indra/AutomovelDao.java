package br.indra;
import java.util.List;

public interface AutomovelDao {

	void salva(Automoveis a);

	List<Automoveis> lista();

}
