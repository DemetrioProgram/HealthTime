package br.com.healthtime.entity;

public class Usuario {

	private String cpf;
	private String dtNascimento;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String cpf, String dtNascimento) {
		super();
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	@Override
	public String toString() {
		return "Usuario [cpf=" + cpf + ", dtNascimento=" + dtNascimento + "]";
	}

}
