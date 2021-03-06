package br.com.healthtime.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cdUsuario;
	@Column(name="nome", nullable = false)
	private String nome;
	@Column(name="nucontatoprincipal", nullable = false)
	private String nuContatoPrincipal;
	@Column(name="nucontatosecundario", nullable = true)
	private String nuContatoSecundario = "";
	@Column(name="dtnascimento", nullable = false)
	private LocalDate dtnascimento;
	@Column(name="cpf", nullable = false)
	private String cpf;
	@Column(name="sus", nullable = true)
	private String sus;
	@Column(name="email", nullable = false)
	private String email;
	@Column(name="nomemae", nullable = false)
	private String nomeMae;
	@Column(name="codigo", nullable = false)
	private Integer codigo;
	@Column(name="flpne", nullable = true)
	private boolean flPne;
	@Column(name="flidoso", nullable = true)
	private boolean flIdoso;
	@Column(name="flgestante", nullable = true)
	private boolean flGestante;
	@Column(name="flmenoridade", nullable = true)
	private boolean flMenorIdade;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cdUnidade", referencedColumnName = "cdUnidade", nullable = false)
	private UnidadeSus cdUnidade;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cdEndereco", referencedColumnName = "cdEndereco", nullable = false)
	private Endereco endereco;
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usuario(String nome, String nuContatoPrincipal, String nuContatoSecundario, LocalDate dtnascimento,
			String cpf, String sus, String email, String nomeMae, Integer codigo, boolean flPne, boolean flIdoso,
			boolean flGestante, boolean flMenorIdade, UnidadeSus cdUnidade, Endereco endereco) {
		super();
		this.nome = nome;
		this.nuContatoPrincipal = nuContatoPrincipal;
		this.nuContatoSecundario = nuContatoSecundario;
		this.dtnascimento = dtnascimento;
		this.cpf = cpf;
		this.sus = sus;
		this.email = email;
		this.nomeMae = nomeMae;
		this.codigo = codigo;
		this.flPne = flPne;
		this.flIdoso = flIdoso;
		this.flGestante = flGestante;
		this.flMenorIdade = flMenorIdade;
		this.cdUnidade = cdUnidade;
		this.endereco = endereco;
	}


	public Usuario(Integer cdUsuario, String nome, String nuContatoPrincipal, String nuContatoSecundario,
			LocalDate dtnascimento, String cpf, String sus, String email, String nomeMae, Integer codigo, boolean flPne,
			boolean flIdoso, boolean flGestante, boolean flMenorIdade, UnidadeSus cdUnidade, Endereco endereco) {
		super();
		this.cdUsuario = cdUsuario;
		this.nome = nome;
		this.nuContatoPrincipal = nuContatoPrincipal;
		this.nuContatoSecundario = nuContatoSecundario;
		this.dtnascimento = dtnascimento;
		this.cpf = cpf;
		this.sus = sus;
		this.email = email;
		this.nomeMae = nomeMae;
		this.codigo = codigo;
		this.flPne = flPne;
		this.flIdoso = flIdoso;
		this.flGestante = flGestante;
		this.flMenorIdade = flMenorIdade;
		this.cdUnidade = cdUnidade;
		this.endereco = endereco;
	}


	public Integer getCdUsuario() {
		return cdUsuario;
	}


	public void setCdUsuario(Integer cdUsuario) {
		this.cdUsuario = cdUsuario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNuContatoPrincipal() {
		return nuContatoPrincipal;
	}


	public void setNuContatoPrincipal(String nuContatoPrincipal) {
		this.nuContatoPrincipal = nuContatoPrincipal;
	}


	public String getNuContatoSecundario() {
		return nuContatoSecundario;
	}


	public void setNuContatoSecundario(String nuContatoSecundario) {
		this.nuContatoSecundario = nuContatoSecundario;
	}


	public LocalDate getDtnascimento() {
		return dtnascimento;
	}


	public void setDtnascimento(LocalDate dtnascimento) {
		this.dtnascimento = dtnascimento;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getSus() {
		return sus;
	}


	public void setSus(String sus) {
		this.sus = sus;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNomeMae() {
		return nomeMae;
	}


	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public boolean isFlPne() {
		return flPne;
	}


	public void setFlPne(boolean flPne) {
		this.flPne = flPne;
	}


	public boolean isFlIdoso() {
		return flIdoso;
	}


	public void setFlIdoso(boolean flIdoso) {
		this.flIdoso = flIdoso;
	}


	public boolean isFlGestante() {
		return flGestante;
	}


	public void setFlGestante(boolean flGestante) {
		this.flGestante = flGestante;
	}


	public boolean isFlMenorIdade() {
		return flMenorIdade;
	}


	public void setFlMenorIdade(boolean flMenorIdade) {
		this.flMenorIdade = flMenorIdade;
	}


	public UnidadeSus getCdUnidade() {
		return cdUnidade;
	}


	public void setCdUnidade(UnidadeSus cdUnidade) {
		this.cdUnidade = cdUnidade;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Usuario [cdUsuario=" + cdUsuario + ", nome=" + nome + ", nuContatoPrincipal=" + nuContatoPrincipal
				+ ", nuContatoSecundario=" + nuContatoSecundario + ", dtnascimento=" + dtnascimento + ", cpf=" + cpf
				+ ", sus=" + sus + ", email=" + email + ", nomeMae=" + nomeMae + ", codigo=" + codigo + ", flPne="
				+ flPne + ", flIdoso=" + flIdoso + ", flGestante=" + flGestante + ", flMenorIdade=" + flMenorIdade
				+ ", cdUnidade=" + cdUnidade + ", endereco=" + endereco + "]";
	}
	
	
	
	
}
