package com.example.fabio.animaisapi.model;

import javax.persistence.*;

@Entity
@Table(name = "classificacoes")
public class Classificacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cla_id")
	private Long id;
	@Column(name = "cla_nome")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "gru_id")
	private Grupo idGrupo;
	

	public Classificacao() {
		super();
	}

	public Classificacao(Long id, String nome, Grupo idGrupo) {
		super();
		this.id = id;
		this.nome = nome;
		this.idGrupo = idGrupo;
		
	}

	/**
	 * @param nome
	 * @param idGrupo
	 */

	public Classificacao(String nome, Grupo idGrupo) {
		super();
		this.nome = nome;
		this.idGrupo = idGrupo;
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

	public Grupo getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Grupo idGrupo) {
		this.idGrupo = idGrupo;
	}
	
	
	@Override
	public String toString() {
		return "Classificacao [id=" + id + ", nome=" + nome + ", idGrupo=" + idGrupo + " ]";
	}

}