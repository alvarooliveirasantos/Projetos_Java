/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.impacta.ads.lp3.empresa.dao.jdbc;

import br.edu.impacta.ads.lp3.empresa.model.Cargo;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class CargoDAO implements GenericoDAO<Cargo> {

    @Override
    public void inserir(Cargo cargo) {
        try {
            String sql = "INSERT INTO EMPRESA.CARGO (NOME) VALUES (?)";
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cargo.getNome());
            ps.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(Cargo cargo) {
        try {
            String sql = "DELETE FROM EMPRESA.CARGO WHERE ID_CARGO=?";
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cargo.getCodigo());
            ps.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Cargo cargo) {
        try {
            String sql = "UPDATE EMPRESA.CARGO SET NOME=? WHERE ID_CARGO=?";
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cargo.getNome());
            ps.setInt(2, cargo.getCodigo());
            ps.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cargo> listar() {
        List<Cargo> cargos = new ArrayList<Cargo>();
        try {
            Connection connection = Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM EMPRESA.CARGO");
            while (result.next()) {
                Cargo cargo = new Cargo();
                cargo.setCodigo(result.getInt("ID_CARGO"));
                cargo.setNome(result.getString("NOME"));
                cargos.add(cargo);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargos;
    }

    public Cargo listarPorId(Cargo cargo) {
        String sql = "SELECT * FROM EMPRESA.CARGO WHERE ID_CARGO = ?";
        try {
            Connection connection = Conexao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cargo.getCodigo());
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                cargo.setCodigo(result.getInt("ID_CARGO"));
                cargo.setNome(result.getString("NOME"));
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargo;
    }

}
