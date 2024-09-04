package com.example.fabio.animaisapi.rest.cidades;

import com.example.fabio.animaisapi.model.Cidade;
import com.example.fabio.animaisapi.model.Paises;

public class CidadeFormRequest {

	private Long id;
	private String nome;
	private Paises idPais;
	
	public CidadeFormRequest() {
		super();
	}

	/**
	 * @param cid_id
	 * @param cid_nome
	 * @param pai_id
	 */
	
	public CidadeFormRequest(Long id, String nome, Paises idPais) {
		super();
		this.id = id;
		this.nome = nome;
		this.idPais= idPais;
		//System.out.println(this.idPais);
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
	
	public Cidade toModel() {
		return new Cidade(id, nome, idPais);
	}
	
	public static CidadeFormRequest fromModel(Cidade cidade) {
		//System.out.println(cidade);
		return new CidadeFormRequest(cidade.getId(), cidade.getNome(), cidade.getIdPais());
	}

}