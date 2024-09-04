package com.example.fabio.animaisapi.rest.grupos;

import com.example.fabio.animaisapi.model.Grupo;

public class GrupoFormRequest {

	private Long gru_id;
	private String gru_nome;
	
	
	public GrupoFormRequest() {
		super();
	}

	/**
	 * @param gru_id
	 * @param gru_nome
	
	 */
	public GrupoFormRequest(Long id, String nome) {
		super();
		this.gru_id = id;
		this.gru_nome = nome;
		
	}

	public Long getId() {
		return gru_id;
	}
	public void setId(Long id) {
		this.gru_id = id;
	}
	public String getNome() {
		return gru_nome;
	}
	public void setNome(String nome) {
		this.gru_nome = nome;
	}
		
	public Grupo toModel() {
		return new Grupo(gru_id, gru_nome);
	}

	public static GrupoFormRequest fromModel(Grupo grupo) {
		return new GrupoFormRequest(grupo.getId(), grupo.getNome());
	}

}