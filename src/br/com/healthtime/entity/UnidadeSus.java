package br.com.healthtime.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "unidadesus")
public class UnidadeSus implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cdUnidade;
	@Column(name = "nutelefone", nullable = false)
	private String telefone;
	@Column(name = "nmunidade", nullable = false)
	private String nmunidade;
	@Column(name = "email", nullable = false)
	private String email;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cdGestor", referencedColumnName = "cdGestor", nullable = false)
	private Gestor cdGestor;
	//@OneToMany(mappedBy = "CdConsulta",  fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private List<Consulta> consultas;
	
	public UnidadeSus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnidadeSus(Integer cdUnidade, String telefone, String nmunidade, String email, Gestor cdGestor) {
		super();
		this.cdUnidade = cdUnidade;
		this.telefone = telefone;
		this.nmunidade = nmunidade;
		this.email = email;
		this.cdGestor = cdGestor;
		//this.consultas = consultas;
	}

	public UnidadeSus(String telefone, String nmunidade, String email, Gestor cdGestor) {
		super();
		this.telefone = telefone;
		this.nmunidade = nmunidade;
		this.email = email;
		this.cdGestor = cdGestor;
		//this.consultas = consultas;
	}

	public Integer getCdUnidade() {
		return cdUnidade;
	}

	public void setCdUnidade(Integer cdUnidade) {
		this.cdUnidade = cdUnidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNmunidade() {
		return nmunidade;
	}

	public void setNmunidade(String nmunidade) {
		this.nmunidade = nmunidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gestor getCdGestor() {
		return cdGestor;
	}

	public void setCdGestor(Gestor cdGestor) {
		this.cdGestor = cdGestor;
	}

	

	@Override
	public String toString() {
		return "UnidadeSus [cdUnidade=" + cdUnidade + ", telefone=" + telefone + ", nmunidade=" + nmunidade + ", email="
				+ email + ", cdGestor=" + cdGestor + "]";
	}	
}
