package com.example.fabio.animaisapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupos")
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gru_id")
	private Long id;
	@Column(name = "gru_nome")
	private String nome;
	

	public Grupo() {
		super();
	}

	public Grupo(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		
	}

	public Grupo(String nome) {
		super();
		this.nome = nome;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", nome=" + nome + "]";
	}

}