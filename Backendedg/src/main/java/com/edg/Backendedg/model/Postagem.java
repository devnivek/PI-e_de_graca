package com.edg.Backendedg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(min = 1, max = 50, message="Limite de 50 Caracteres")
	private String titulo;
	
	@NotBlank
	@Size(min = 1, max = 255, message="Limite de 255 Caracteres")
	private String descricao;
	
	private int curtir;
	
	@NotBlank
	@Size(min = 1, max = 350, message="Limite de 350 Caracteres")
	private String midia;
	
	@NotBlank
	@Size(min = 1, max = 50, message="Limite de 50 Caracteres")
	private String quemFaz;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getLike() {
		return curtir;
	}

	public void setLike(int like) {
		this.curtir = like;
	}

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}

	public String getQuemFaz() {
		return quemFaz;
	}

	public void setQuemFaz(String quemFaz) {
		this.quemFaz = quemFaz;
	}
	
	
}
