package com.example.fabio.animaisapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "especies")
public class Especie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "esp_id")
	private Long id;
	
	@Column(name = "esp_nome")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "cla_id")
	private Classificacao idClassificacao;


	public Especie() {
		super();
	}

	public Especie(Long id, String nome, Classificacao idClassificacao) {
		
		super();

		this.id = id;
		this.nome = nome;
		this.idClassificacao = idClassificacao;

	}

	/**
	 * @param nome
	 * @param idClassificacao
	 */
	
	public Especie(String nome, Classificacao idClassificacao) {
		super();
		this.nome = nome;
		this.idClassificacao = idClassificacao;
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

	public Classificacao getIdClassificacao() {
		return idClassificacao;
	}

	public void setIdClassificacao(Classificacao idClassificacao) {
		this.idClassificacao = idClassificacao;
	}


	
	@Override
	public String toString() {
		return "Especie [id=" + id + ", nome=" + nome + ", idClassificacao=" + idClassificacao + " ]";
	}

}