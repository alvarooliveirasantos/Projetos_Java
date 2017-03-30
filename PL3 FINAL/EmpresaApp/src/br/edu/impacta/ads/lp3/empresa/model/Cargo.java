/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.impacta.ads.lp3.empresa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Israel
 */
@Entity
@Table(name = "CARGO", schema = "EMPRESA")
public class Cargo implements Serializable {

    @Id
    @Column(name = "ID_CARGO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nome;

    public Cargo() {
    }

    public Cargo(Integer codigo) {
        this.codigo = codigo;
    }

    public Cargo(String nome) {
        this.nome = nome;
    }

    public Cargo(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
