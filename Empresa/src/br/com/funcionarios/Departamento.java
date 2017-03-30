package br.com.funcionarios;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Departamento")
public class Departamento {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod_departamento;
	String nome;
	
	public int getId_departamento() {
		return cod_departamento;
	}
	public void setId_departamento(int id_departamento) {
		this.cod_departamento = id_departamento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
