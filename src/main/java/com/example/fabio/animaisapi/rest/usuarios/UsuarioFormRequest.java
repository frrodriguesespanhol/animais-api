package com.example.fabio.animaisapi.rest.usuarios;

import com.example.fabio.animaisapi.model.Usuario;

public class UsuarioFormRequest {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String tipo;
	
	public UsuarioFormRequest() {
		super();
	}
		
	public UsuarioFormRequest(Long id, String nome, String email, String senha,	String tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Usuario toModel() {
		return new Usuario(id, nome, email, senha, tipo);
	}
	
	public static UsuarioFormRequest fromModel(Usuario usuario) {
		//System.out.println(usuario);
		return new UsuarioFormRequest(usuario.getId(), usuario.getNome(),
				                      usuario.getEmail(), usuario.getSenha(), usuario.getTipo() );
	}

}