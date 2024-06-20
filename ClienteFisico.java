package model;

public class ClienteFisico extends Cliente{
	private int idClienteFisico;
	private String rg;
	
	
	
	public ClienteFisico(int idCliente, String nome, String telefone, String cep, String logradouro, String bairro,
			String estado, int idClienteFisico, String rg) {
		super(idCliente, nome, telefone, cep, logradouro, bairro, estado);
		this.idClienteFisico = idClienteFisico;
		this.rg = rg;
	}

	public int getIdClienteFisico() {
		return idClienteFisico;
	}

	public void setIdClienteFisico(int idClienteFisico) {
		this.idClienteFisico = idClienteFisico;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "ClienteFisico [idClienteFisico=" + idClienteFisico + ", rg=" + rg + "]";
	}
	
}
