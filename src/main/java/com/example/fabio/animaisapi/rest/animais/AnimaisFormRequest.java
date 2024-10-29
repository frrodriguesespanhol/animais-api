package com.example.fabio.animaisapi.rest.animais;

import com.example.fabio.animaisapi.model.Animais;
import com.example.fabio.animaisapi.model.Classificacao;
import com.example.fabio.animaisapi.model.Especie;
import com.example.fabio.animaisapi.model.Grupo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zaxxer.hikari.util.SuspendResumeLock;
import org.springframework.format.annotation.DateTimeFormat;

import javax.swing.*;
import java.text.DateFormat;
import java.util.Date;

public class AnimaisFormRequest {

	private Long ani_id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date data;
//	private Grupo idGrupoAnimal;
//	private Classificacao idClassificacaoAnimal;
	private Especie idEspecieAnimal;
	private String especie;
	private String ani_localizacao;
	private String ani_cadastrado_por;
	private String email;
	private String ani_estado;
	private String ani_comentario;

	private String ani_foto1;

	private String ani_foto2;

	public AnimaisFormRequest() {
		super();
	}

	/**
	 * @param id
	 * @param data
//	 * @param idGrupoAnimal
//	 * @param idClassificacaoAnimal
	 * @param idEspecieAnimal
	 * @param especie
	 * @param localizacao
	 * @param cadastradopor
	 * @param email
	 * @param estado
	 * @param comentario
	 * @param foto1
	 * @param foto2
	 */
	public AnimaisFormRequest(Long id, Date data, Especie idEspecieAnimal, String especie, String localizacao, String cadastradopor,
							  String email, String estado, String comentario, String foto1, String foto2) {
		super();
		this.ani_id = id;
		this.data = data;
//		this.idGrupoAnimal = idGrupoAnimal;
//		this.idClassificacaoAnimal= idClassificacaoAnimal;
		this.idEspecieAnimal = idEspecieAnimal;
		this.especie = especie;
		this.ani_localizacao = localizacao;
		this.ani_cadastrado_por = cadastradopor;
		this.email = email;
		this.ani_estado = estado;
		this.ani_comentario = comentario;
		this.ani_foto1 = foto1;
		this.ani_foto2 = foto2;

	}

	public Long getId() {
		return ani_id;
	}
	public void setId(Long id) {
		this.ani_id = id;
	}
	public Date getData() {	return data; }
	public void setData(Date data) {this.data = data;}
//	public Grupo getIdGrupoAnimal() {
//		return idGrupoAnimal;
//	}
//	public void setIdGrupoAnimal(Grupo idGrupoAnimal) {
//		this.idGrupoAnimal = idGrupoAnimal;
//	}
//	public Classificacao getIdClassificacaoAnimal() {
//		return idClassificacaoAnimal;
//	}
//	public void setIdClassificacaoAnimal(Classificacao idClassificacaoAnimal) {	this.idClassificacaoAnimal = idClassificacaoAnimal;	}
	public Especie getIdEspecieAnimal() {
		return idEspecieAnimal;
	}
	public void setIdEspecieAnimal(Especie idEspecieAnimal) {
		this.idEspecieAnimal = idEspecieAnimal;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getLocalizacao() {
		return ani_localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.ani_localizacao = localizacao;
	}
	public String getCadastradopor() {
		return ani_cadastrado_por;
	}
	public void setCadastradopor(String cadastradopor) {
		this.ani_cadastrado_por = cadastradopor;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEstado() {
		return ani_estado;
	}
	public void setEstado(String estado) {
		this.ani_estado = estado;
	}
	public String getComentario() {
		return ani_comentario;
	}
	public void setComentario(String comentario) {
		this.ani_comentario = comentario;
	}
	public String getFoto1() {
		return ani_foto1;
	}
	public void setFoto1(String foto1) {
		this.ani_foto1 = foto1;
	}
	public String getFoto2() {
		return ani_foto2;
	}
	public void setFoto2(String foto2) {
		this.ani_foto2 = foto2;
	}

	public Animais toModel() {
		return new Animais(ani_id, data, idEspecieAnimal, especie, ani_localizacao,
				ani_cadastrado_por, email, ani_estado, ani_comentario, ani_foto1, ani_foto2);
	}

	public static AnimaisFormRequest fromModel(Animais animais) {
		//System.out.println(animais.getData().toString().substring(8,10) + '/' + animais.getData().toString().substring(5,7) + "/" + animais.getData().toString().substring(0,4) );
		return new AnimaisFormRequest(animais.getId(), animais.getData(), animais.getIdEspecieAnimal(), animais.getEspecie(),
				animais.getLocalizacao(), animais.getCadastradopor(), animais.getEmail(), animais.getEstado(),
				animais.getComentario(), animais.getFoto1(), animais.getFoto2());
	}

}