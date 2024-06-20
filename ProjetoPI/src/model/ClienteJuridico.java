package model;

public class ClienteJuridico extends Cliente{
	private int idClienteJuridico;
	private String cnpj;
	private String razaoSocial;
	
	

	public ClienteJuridico(int idCliente, String nome, String telefone, String cep, String logradouro, String bairro,
			String estado, int idClienteJuridico, String cnpj, String razaoSocial) {
		super(idCliente, nome, telefone, cep, logradouro, bairro, estado);
		this.idClienteJuridico = idClienteJuridico;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}


	public int getIdClienteJuridico() {
		return idClienteJuridico;
	}


	public void setIdClienteJuridico(int idClienteJuridico) {
		this.idClienteJuridico = idClienteJuridico;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	@Override
	public String toString() {
		return "ClienteJuridico [idClienteJuridico=" + idClienteJuridico + ", cnpj=" + cnpj + ", razaoSocial="
				+ razaoSocial + "]";
	}
	
}
