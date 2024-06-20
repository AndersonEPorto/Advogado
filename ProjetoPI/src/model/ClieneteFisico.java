package model;

public class ClieneteFisico extends Cliente{
	private int idClieneteFisico;
	private String rg;
	
	
	
	public ClieneteFisico(int idCliente, String nome, String telefone, String cep, String logradouro, String bairro,
			String estado, int idClieneteFisico, String rg) {
		super(idCliente, nome, telefone, cep, logradouro, bairro, estado);
		this.idClieneteFisico = idClieneteFisico;
		this.rg = rg;
	}

	public int getIdClieneteFisico() {
		return idClieneteFisico;
	}

	public void setIdClieneteFisico(int idClienteFisico) {
		this.idClieneteFisico = idClienteFisico;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "ClieneteFisico [idClieneteFisico=" + idClieneteFisico + ", rg=" + rg + "]";
	}
	
}
