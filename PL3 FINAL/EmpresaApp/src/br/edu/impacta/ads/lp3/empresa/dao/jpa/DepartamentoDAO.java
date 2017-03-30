/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.impacta.ads.lp3.empresa.dao.jpa;

import br.edu.impacta.ads.lp3.empresa.dao.jdbc.GenericoDAO;
import br.edu.impacta.ads.lp3.empresa.model.Departamento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Israel
 */
public class DepartamentoDAO implements GenericoDAO<Departamento> {

    @Override
    public void inserir(Departamento departamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Departamento departamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Departamento departamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Departamento> listar() {
        List<Departamento> departamentos = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpresaAppPU");
        EntityManager entity = emf.createEntityManager();
        Query query = entity.createQuery("SELECT c FROM Departamento c");
        departamentos = query.getResultList();
        emf.close();
        return departamentos;
    }

}
