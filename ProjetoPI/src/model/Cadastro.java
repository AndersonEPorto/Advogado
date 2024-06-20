package model;

import java.sql.Date;

public class Cadastro {

	private int idCadastro;
	private Date data;
	
	public Cadastro(int idCadastro, Date data) {
		this.idCadastro = idCadastro;
		this.data = data;
	}

	public int getIdCadastro() {
		return idCadastro;
	}

	public void setIdCadastro(int idCadastro) {
		this.idCadastro = idCadastro;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Cadastro [idCadastro=" + idCadastro + ", data=" + data + "]";
	}
	
}
