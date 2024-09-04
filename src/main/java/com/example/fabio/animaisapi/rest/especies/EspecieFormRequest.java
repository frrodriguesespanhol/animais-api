package com.example.fabio.animaisapi.rest.especies;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.fabio.animaisapi.model.Animais;
import com.example.fabio.animaisapi.model.Classificacao;
import com.example.fabio.animaisapi.model.Especie;
import com.example.fabio.animaisapi.model.Grupo;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EspecieFormRequest {

	private Long esp_id;
	private String esp_nome;
	private Classificacao idClassificacao;
		
	public EspecieFormRequest() {
		super();
	}

	/**
	 * @param esp_id
	 * @param esp_nome
	 * @param cla_id
	 */
	
	public EspecieFormRequest(Long id, String nome, Classificacao idClassificacao) {
		super();
		this.esp_id = id;
		this.esp_nome = nome;
		this.idClassificacao= idClassificacao;
	}
	
	public Long getId() {
		return esp_id;
	}
	public void setId(Long id) {
		this.esp_id = id;
	}
	public String getNome() {
		return esp_nome;
	}
	public void setNome(String nome) {
		this.esp_nome= nome;
	}
	public Classificacao getIdClassificacao() {
		return idClassificacao;
	}
	public void setIdClassificacao(Classificacao idClassificacao) {
		this.idClassificacao = idClassificacao;
	}

	public Especie toModel() {
		return new Especie(esp_id, esp_nome, idClassificacao);
	}
	
	public static EspecieFormRequest fromModel(Especie especie) {
		//System.out.println(especie);
		return new EspecieFormRequest(especie.getId(), especie.getNome(), especie.getIdClassificacao());
	}

}