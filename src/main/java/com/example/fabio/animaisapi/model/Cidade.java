package com.example.fabio.animaisapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cidades")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid_id")
	private Long id;
	@Column(name = "cid_nome")
	private String nome;
	@ManyToOne
	@JoinColumn(name = "pai_id")
	private Paises idPais;



	public Cidade() {
		super();
	}

	public Cidade(Long id, String nome, Paises idPais) {
		super();
		this.id = id;
		this.nome = nome;
		this.idPais = idPais;
		//System.out.println(id + " " + nome + " " + idPais);
	}

	/**
	 * @param nome
	 * @param idPais
	 */
	public Cidade(String nome, Paises idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
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

	public Paises getIdPais() {
		return idPais;
	}

	public void setIdPais(Paises idPais) {
		this.idPais = idPais;
	}

	
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", idpais=" + idPais + " ]";
	}

}