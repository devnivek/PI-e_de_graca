package com.edg.Backendedg.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_tema")
public class ModelTema {
	
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 50, message="Limite de 50 Caracteres")
	private String area;
	
	@NotNull
	@Size(min = 1, max = 50, message="Limite de 50 Caracteres")
	private String tipo_de_acao;
	
	@Temporal(TemporalType.TIMESTAMP) 
	private Date data;
	
	@NotNull
	@Size(min = 1, max = 50, message="Limite de 50 Caracteres")
	private String publico;
	
	@NotNull
	@Size(min = 1, max = 50, message="Limite de 50 Caracteres")
	private String cidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTipo_de_acao() {
		return tipo_de_acao;
	}

	public void setTipo_de_acao(String tipo_de_acao) {
		this.tipo_de_acao = tipo_de_acao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getPublico() {
		return publico;
	}

	public void setPublico(String publico) {
		this.publico = publico;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
}