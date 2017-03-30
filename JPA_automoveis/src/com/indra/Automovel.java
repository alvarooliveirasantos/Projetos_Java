package com.indra;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity 
@Table(name="Automovel")
public class Automovel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	private Integer anodeFabricacao;
	private String modelo;
	private Integer anoModelo;
	private String marca;
	private String observacoes;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Integer getAnodeFabricacao() {
		return anodeFabricacao;
	}

	public void setAnodeFabricacao(Integer anodeFabricacao) {
		this.anodeFabricacao = anodeFabricacao;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
