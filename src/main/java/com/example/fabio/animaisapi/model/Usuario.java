package com.example.fabio.animaisapi.model;

import com.example.fabio.animaisapi.model.exceptions.ValidationException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private Long id;
	@Column(name = "usu_nome")
	private String nome;
	@Column(name = "usu_email", unique = true)
	private String email;
	@Column(name = "usu_senha")
	private String senha;

	@Column(name = "usu_tipo")
	private String tipo;



	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, String email,
					String senha, String tipo) {

		if (nome == null) throw new ValidationException("Nome é obrigatório");
		if (email == null) throw new ValidationException("E-mail é obrigatório");
		if (senha == null) throw new ValidationException("Senha é obrigatória");
		if (tipo == null) throw new ValidationException("Tipo é obrigatório");

		//super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
		System.out.println(id + " " + nome + " " + email + " "  + senha + " " 
							+ " " + tipo );
	}

	public Usuario(String nome, String email, String senha, String tipo) {
		super();
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

	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ","
				+ " email=" + email + "," + " senha=" + senha + "," 
				+ "," + " tipo=" + tipo + " ]";
	}

}