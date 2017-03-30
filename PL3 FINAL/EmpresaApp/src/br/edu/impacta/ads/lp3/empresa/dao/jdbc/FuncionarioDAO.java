/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.impacta.ads.lp3.empresa.dao.jdbc;

import br.edu.impacta.ads.lp3.empresa.model.Cargo;
import br.edu.impacta.ads.lp3.empresa.model.Departamento;
import br.edu.impacta.ads.lp3.empresa.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Israel
 */
public class FuncionarioDAO extends Object implements GenericoDAO<Funcionario> {

    @Override
    public void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO EMPRESA.FUNCIONARIO (NOME, DT_CONTRATACAO, ID_CARGO, ID_DEPARTAMENTO) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setDate(2, new java.sql.Date(funcionario.getContratacao().getTime()));
            ps.setInt(3, funcionario.getCargo().getCodigo());
            ps.setInt(4, funcionario.getDepartamento().getCodigo());
            ps.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Funcionario funcionario) {
        String sql = "UPDATE EMPRESA.FUNCIONARIO SET NOME=?, DT_CONTRATACAO=?, ID_CARGO=?, ID_DEPARTAMENTO=? WHERE ID_FUNCIONARIO=?";
        try {
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setDate(2, new java.sql.Date(funcionario.getContratacao().getTime()));
            ps.setInt(3, funcionario.getCargo().getCodigo());
            ps.setInt(4, funcionario.getDepartamento().getCodigo());
            ps.setInt(5, funcionario.getCodigo());
            ps.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(Funcionario funcionario) {
        String sql = "DELETE FROM EMPRESA.FUNCIONARIO WHERE ID_FUNCIONARIO=?";
        try {
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, funcionario.getCodigo());
            ps.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList();

        String sql = "SELECT F.ID_FUNCIONARIO, F.NOME, F.DT_CONTRATACAO, C.ID_CARGO, C.NOME CARGO, D.ID_DEPARTAMENTO, D.NOME DEPARTAMENTO "
                + " FROM EMPRESA.FUNCIONARIO F "
                + " INNER JOIN EMPRESA.CARGO C "
                + " ON C.ID_CARGO = F.ID_CARGO "
                + " INNER JOIN EMPRESA.DEPARTAMENTO D "
                + " ON D.ID_DEPARTAMENTO = F.ID_DEPARTAMENTO";
        try {
            Connection connection = Conexao.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(result.getInt("ID_FUNCIONARIO"));
                funcionario.setNome(result.getString("NOME"));
                funcionario.setContratacao(new Date(result.getDate("DT_CONTRATACAO").getTime()));
                funcionario.setCargo(new Cargo(result.getInt("ID_CARGO"), result.getString("CARGO")));
                funcionario.setDepartamento(new Departamento(result.getInt("ID_DEPARTAMENTO"), result.getString("DEPARTAMENTO")));
                funcionarios.add(funcionario);
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }

    public Funcionario listarPorId(Funcionario funcionario) {
        String sql = "SELECT F.ID_FUNCIONARIO, F.NOME, F.DT_CONTRATACAO, C.ID_CARGO, C.NOME CARGO, D.ID_DEPARTAMENTO, D.NOME DEPARTAMENTO "
                + " FROM EMPRESA.FUNCIONARIO F "
                + " INNER JOIN EMPRESA.CARGO C "
                + " ON C.ID_CARGO = F.ID_CARGO "
                + " INNER JOIN EMPRESA.DEPARTAMENTO D "
                + " ON D.ID_DEPARTAMENTO = F.ID_DEPARTAMENTO "
                + " WHERE ID_FUNCIONARIO = ?";
        try {
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, funcionario.getCodigo());
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                funcionario.setCodigo(result.getInt("ID_FUNCIONARIO"));
                funcionario.setNome(result.getString("NOME"));
                funcionario.setContratacao(new Date(result.getDate("DT_CONTRATACAO").getTime()));
                funcionario.setCargo(new Cargo(result.getInt("ID_CARGO"), result.getString("CARGO")));
                funcionario.setDepartamento(new Departamento(result.getInt("ID_DEPARTAMENTO"), result.getString("DEPARTAMENTO")));
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }
}
