package model;

public class Cliente {

	private int idCliente;
	private String nome;
	private String telefone;
	private String cep;
	private String logradouro;
	private String bairro;
	private String estado;

	public Cliente(int idCliente, String nome, String telefone, String cep, String logradouro, String bairro,
			String estado) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.telefone = telefone;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.estado = estado;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", telefone=" + telefone + ", cep=" + cep
				+ ", logradouro=" + logradouro + ", bairro=" + bairro + ", estado=" + estado + "]";
	}
	
}
