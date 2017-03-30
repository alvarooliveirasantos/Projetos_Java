


import br.edu.impacta.ads.lp3.empresa.model.Departamento;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Israel
 */
public interface GenericoDAO<E> extends Serializable {

    void inserir(E e);

    void remover(E e);

    void alterar(E e);

    List<E> listar();
}
