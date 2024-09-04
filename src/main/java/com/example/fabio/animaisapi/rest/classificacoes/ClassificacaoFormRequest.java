package com.example.fabio.animaisapi.rest.classificacoes;

import com.example.fabio.animaisapi.model.Classificacao;
import com.example.fabio.animaisapi.model.Grupo;
import com.example.fabio.animaisapi.model.Paises;

public class ClassificacaoFormRequest {

	private Long cla_id;
	private String cla_nome;
	private Grupo idGrupo;

	public ClassificacaoFormRequest() {
		super();
	}

	/**
	 * @param cla_id
	 * @param cla_nome
	 * @param gru_id
	 */

	public ClassificacaoFormRequest(Long id, String nome, Grupo idGrupo)  {
		super();
		this.cla_id = id;
		this.cla_nome = nome;
		this.idGrupo= idGrupo;
	}

	public Long getId() {
		return cla_id;
	}
	public void setId(Long id) {
		this.cla_id = id;
	}
	public String getNome() {
		return cla_nome;
	}
	public void setNome(String nome) {
		this.cla_nome = nome;
	}
	public Grupo getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Grupo idGrupo) {
		this.idGrupo = idGrupo;
	}
		
	public Classificacao toModel() {
		return new Classificacao(cla_id, cla_nome, idGrupo);
	}

	public static ClassificacaoFormRequest fromModel(Classificacao classificacao) {
		return new ClassificacaoFormRequest(classificacao.getId(), classificacao.getNome(), classificacao.getIdGrupo());
	}

}