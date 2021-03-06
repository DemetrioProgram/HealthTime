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
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cdConsulta;
	@Column(name = "data", nullable = false)
	private LocalDate data;
	@Column(name = "horario", nullable = false)
	private String horario;
	@Column(name = "flretorno", nullable = false)
	private boolean retorno;
	@Column(name = "flvacina", nullable = true)
	private boolean flvacina;
	@Column(name = "deprediagnostico", nullable = true)
	private String deprediagnostico;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cdArquivo", referencedColumnName = "cdArquivo", nullable = true)
	private Receita cdArquivo;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cdPaciente", referencedColumnName = "cdUsuario", nullable = true)
	private Usuario cdPaciente;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cdMedico", referencedColumnName = "cdUsuario", nullable = false)
	private Usuario cdMedico;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cdFuncioanrio", referencedColumnName = "cdUsuario", nullable = false)
	private Usuario cdFuncioanrio;
	@ManyToOne
	@JoinColumn(name = "cdUnidade", nullable = false)
	private UnidadeSus cdUnidade;

	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consulta(Integer cdConsulta, LocalDate data, String horario, boolean retorno, boolean flvacina,
			String deprediagnostico, Receita cdArquivo, Usuario cdPaciente, Usuario cdMedico, Usuario cdFuncioanrio, UnidadeSus cdUnidade) {
		super();
		this.cdConsulta = cdConsulta;
		this.data = data;
		this.horario = horario;
		this.retorno = retorno;
		this.flvacina = flvacina;
		this.deprediagnostico = deprediagnostico;
		this.cdArquivo = cdArquivo;
		this.cdPaciente = cdPaciente;
		this.cdMedico = cdMedico;
		this.cdFuncioanrio = cdFuncioanrio;
		this.cdUnidade = cdUnidade;
	}

	public Consulta(LocalDate data, String horario, boolean retorno, boolean flvacina, String deprediagnostico,
			Receita cdArquivo, Usuario cdPaciente, Usuario cdMedico, Usuario cdFuncioanrio, UnidadeSus cdUnidade) {
		super();
		this.data = data;
		this.horario = horario;
		this.retorno = retorno;
		this.flvacina = flvacina;
		this.deprediagnostico = deprediagnostico;
		this.cdArquivo = cdArquivo;
		this.cdPaciente = cdPaciente;
		this.cdMedico = cdMedico;
		this.cdFuncioanrio = cdFuncioanrio;
		this.cdUnidade = cdUnidade;
	}

	public Integer getCdConsulta() {
		return cdConsulta;
	}

	public void setCdConsulta(Integer cdConsulta) {
		this.cdConsulta = cdConsulta;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public boolean isRetorno() {
		return retorno;
	}

	public void setRetorno(boolean retorno) {
		this.retorno = retorno;
	}

	public boolean isFlvacina() {
		return flvacina;
	}

	public void setFlvacina(boolean flvacina) {
		this.flvacina = flvacina;
	}

	public String getDeprediagnostico() {
		return deprediagnostico;
	}

	public void setDeprediagnostico(String deprediagnostico) {
		this.deprediagnostico = deprediagnostico;
	}

	public Receita getCdArquivo() {
		return cdArquivo;
	}

	public void setCdArquivo(Receita cdArquivo) {
		this.cdArquivo = cdArquivo;
	}

	public Usuario getCdPaciente() {
		return cdPaciente;
	}

	public void setCdPaciente(Usuario cdPaciente) {
		this.cdPaciente = cdPaciente;
	}

	public Usuario getCdMedico() {
		return cdMedico;
	}

	public void setCdMedico(Usuario cdMedico) {
		this.cdMedico = cdMedico;
	}

	public Usuario getCdFuncioanrio() {
		return cdFuncioanrio;
	}

	public void setCdFuncioanrio(Usuario cdFuncioanrio) {
		this.cdFuncioanrio = cdFuncioanrio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public UnidadeSus getCdUnidade() {
		return cdUnidade;
	}

	public void setCdUnidade(UnidadeSus cdUnidade) {
		this.cdUnidade = cdUnidade;
	}

	@Override
	public String toString() {
		return "Consulta [cdConsulta=" + cdConsulta + ", data=" + data + ", horario=" + horario + ", retorno=" + retorno
				+ ", flvacina=" + flvacina + ", deprediagnostico=" + deprediagnostico + ", cdArquivo=" + cdArquivo
				+ ", cdPaciente=" + cdPaciente + ", cdMedico=" + cdMedico + ", cdFuncioanrio=" + cdFuncioanrio
				+ ", cdUnidade=" + cdUnidade + "]";
	}

	
}
