package com.example.fabio.animaisapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "animais")
public class Animais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ani_id")
	private Long id;
	@Column(name = "ani_data")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date data;
//	@ManyToOne
//	@JoinColumn(name = "gru_id")
//	private Grupo idGrupoAnimal;
//
//	@ManyToOne
//	@JoinColumn(name = "cla_id")
//	private Classificacao idClassificacaoAnimal;

	@ManyToOne
	@JoinColumn(name = "esp_id")
	private Especie idEspecieAnimal;

	@Column(name = "ani_especie")
	private String especie;

	@Column(name = "ani_localizacao")
	private String localizacao;

	@Column(name = "ani_cadastrado_por")
	private String cadastradopor;

	@Column(name = "ani_email")
	private String email;

	@Column(name = "ani_estado")
	private String estado;

	@Column(name = "ani_comentario")
	private String comentario;

	@Column(name = "ani_foto1")
	private String foto1;

	@Column(name = "ani_foto2")
	private String foto2;

	public Animais() {
		super();
	}

	public Animais(Long id, Date data, Especie idEspecieAnimal,
				   String especie, String localizacao, String cadastradopor, String email, String estado, String comentario, String foto1,
				   String foto2) {
		super();
		this.id = id;
		this.data = data;
//		this.idGrupoAnimal = idGrupoAnimal;
//		this.idClassificacaoAnimal = idClassificacaoAnimal;
		this.idEspecieAnimal = idEspecieAnimal;
		this.especie = especie;
		this.localizacao = localizacao;
		this.cadastradopor = cadastradopor;
		this.email = email;
		this.estado = estado;
		this.comentario = comentario;
		this.foto1 = foto1;
		this.foto2 = foto2;
	}

	/**
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
	public Animais(Date data, Especie idEspecieAnimal,
				   String especie, String localizacao, String cadastradopor, String email, String estado, String comentario,
				   String foto1, String foto2) {
		super();
		this.data = data;
//		this.idGrupoAnimal = idGrupoAnimal;
//		this.idClassificacaoAnimal = idClassificacaoAnimal;
		this.idEspecieAnimal = idEspecieAnimal;
		this.especie = especie;
		this.localizacao = localizacao;
		this.cadastradopor = cadastradopor;
		this.email = email;
		this.estado = estado;
		this.comentario = comentario;
		this.foto1 = foto1;
		this.foto2 = foto2;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

//	public Grupo getIdGrupoAnimal() {
//		return idGrupoAnimal;
//	}
//
//	public void setIdGrupoAnimal(Grupo idGrupoAnimal) {
//		this.idGrupoAnimal = idGrupoAnimal;
//	}
//
//	public Classificacao getIdClassificacaoAnimal() {
//		return idClassificacaoAnimal;
//	}
//
//	public void setIdClassificacaoAnimal(Classificacao idClassificacaoAnimal) {
//		this.idClassificacaoAnimal = idClassificacaoAnimal;
//	}

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
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getCadastradopor() {
		return cadastradopor;
	}

	public void setCadastradopor(String cadastradopor) { this.cadastradopor = cadastradopor; }
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) { this.email = email; }

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) { this.estado = estado; }

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) { this.comentario = comentario; }

	public String getFoto1() {
		return foto1;
	}

	public void setFoto1(String foto1) { this.foto1 = foto1; }

	public String getFoto2() {
		return foto2;
	}

	public void setFoto2(String foto2) { this.foto2 = foto2; }

	@Override
	public String toString() {
		return "Animais [id=" + id + ", data=" + data + ", +specie_animal=" + idEspecieAnimal + ", espécie" + especie + ", localização=" + localizacao + "," +
				"cadastrado por=" + cadastradopor + ", e-mail=" + email + ", estado=" + estado + "," + "comentario=" + comentario +
				"foto1=" + foto1 + "foto2=" + foto2 + " ]";
	}

}