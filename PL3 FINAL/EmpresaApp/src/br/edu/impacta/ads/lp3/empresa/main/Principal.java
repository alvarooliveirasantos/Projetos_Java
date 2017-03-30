/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.impacta.ads.lp3.empresa.main;

import br.edu.impacta.ads.lp3.empresa.dao.jpa.CargoDAO;
import br.edu.impacta.ads.lp3.empresa.model.Cargo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Israel
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        
        List<Cargo> cargos = new CargoDAO().listar();
        
        for (Cargo cargo : cargos) {
            System.out.println(cargo.getCodigo() + " " + cargo.getNome());
        }
        
    }
}
