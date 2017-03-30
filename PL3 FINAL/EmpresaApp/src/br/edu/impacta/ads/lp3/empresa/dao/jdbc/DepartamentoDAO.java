/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.impacta.ads.lp3.empresa.dao.jdbc;

import br.edu.impacta.ads.lp3.empresa.model.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Israel
 */
public class DepartamentoDAO implements GenericoDAO<Departamento>{

    @Override
    public void inserir(Departamento departamento) {
        try {
            String sql = "INSERT INTO EMPRESA.DEPARTAMENTO (NOME) VALUES (?)";
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, departamento.getNome());
            ps.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(Departamento departamento) {
        try {
            String sql = "DELETE FROM EMPRESA.DEPARTAMENTO WHERE ID_CARGO=?";
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, departamento.getCodigo());
            ps.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Departamento departamento) {
        try {
            String sql = "UPDATE EMPRESA.DEPARTAMENTO SET NOME=? WHERE ID_CARGO=?";
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, departamento.getNome());
            ps.setInt(2, departamento.getCodigo());
            ps.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Departamento> listar() {
        List<Departamento> departamentos = new ArrayList<Departamento>();
        try {
           Connection connection = Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.
                    executeQuery("SELECT * FROM EMPRESA.DEPARTAMENTO");
            while (result.next()) {
                Departamento departamento = new Departamento();
                departamento.setCodigo(result.getInt("ID_DEPARTAMENTO"));
                departamento.setNome(result.getString("NOME"));
                departamentos.add(departamento);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departamentos;
    }
    
        public Departamento listarPorId(Departamento departamento) {
        String sql = "SELECT * FROM EMPRESA.DEPARTAMENTO WHERE ID_DEPARTAMENTO = ?";
        try {
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, departamento.getCodigo());
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                departamento.setCodigo(result.getInt("ID_DEPARTAMENTO"));
                departamento.setNome(result.getString("NOME"));
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departamento;
    }

}
