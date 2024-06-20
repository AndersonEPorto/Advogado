package model;

public class Advogado {
	private int idAdvogado;
	private String nome;
	private String numeroOAB;
	private String especializacao;
	private String telefone;
	private String email;
	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	
	public Advogado() {
	}

	public Advogado(int idAdvogado) {
		this.idAdvogado = idAdvogado;
	}

	public Advogado(int idAdvogado, String nome, String numeroOAB, String especializacao, String telefone, String email,
			String cep, String logradouro, String bairro, String cidade, String estado) {
		this.idAdvogado = idAdvogado;
		this.nome = nome;
		this.numeroOAB = numeroOAB;
		this.especializacao = especializacao;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public int getIdAdvogado() {
		return idAdvogado;
	}

	public void setIdAdvogado(int idAdvogado) {
		this.idAdvogado = idAdvogado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroOAB() {
		return numeroOAB;
	}

	public void setNumeroOAB(String numeroOAB) {
		this.numeroOAB = numeroOAB;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Advogado [idAdvogado=" + idAdvogado + ", nome=" + nome + ", numeroOAB=" + numeroOAB
				+ ", especializacao=" + especializacao + ", telefone=" + telefone + ", email=" + email + ", cep=" + cep
				+ ", logradouro=" + logradouro + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
				+ "]";
	}
}
