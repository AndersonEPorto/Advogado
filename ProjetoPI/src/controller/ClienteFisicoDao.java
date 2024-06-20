package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ClieneteFisico;
import model.Cliente;

public class ClienteFisicoDao {

	
	public Connection getConexao() throws ClassNotFoundException {

		// Driver
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);

		// Endereço do banco de dados
		String url = "jdbc:mysql://localhost:3306/jovem_programador";

		// Usuario
		String user = "root";

		// Senha
		String password = "root";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão realizada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public int inserirClienteFisico(ClieneteFisico clienteFisicoNovo) {

		// SQL

		String insert = "INSERT INTO" + " clienteFisico(nome, telefone, cep, logradouro, bairro, estado, idClieneteFisico, rg) "
				+ "VALUES (?,?,?,?,?,?,?,?)";

		try {
			Connection conn = getConexao();

			PreparedStatement pst = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

			// Atribuindo os valores aos ?????
		

			pst.setString(1, clienteFisicoNovo.getNome());
			pst.setString(2, clienteFisicoNovo.getTelefone());
			pst.setString(3, clienteFisicoNovo.getLogradouro());
			pst.setString(4, clienteFisicoNovo.getBairro());
			pst.setString(5, clienteFisicoNovo.getEstado());
			pst.setInt(6, clienteFisicoNovo.getIdClieneteFisico());
			pst.setString(7, clienteFisicoNovo.getRg());
			
			
			// Executando 

			pst.executeUpdate();

			// Retornar a chave

			ResultSet rs = pst.getGeneratedKeys();
			int chaveGerada;
			if (rs.next() == true) {
				chaveGerada = rs.getInt(1);
				return chaveGerada;

			}

			rs.close();
			pst.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}

	public List<ClieneteFisico> listaPacientes() {
		String sql = "select * from clientesFisico";
		List<ClieneteFisico> lista = new ArrayList<>();

		try {

			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			// variavel rs tem a linha do banco de dados

			while (rs.next() == true) {

				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				

				
				ClieneteFisico cliente = new ClieneteFisico(id, nome, telefone, cep, lagradouro, bairro, estado, idClieneteFisico, rg);
				lista.add(clienteFisico);

			}

			rs.close();
			pst.close();
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return lista;

	}

	public void deletarPaciente(int id) {

		String sql = "delete from pacientes where id = ? ";

		try {

			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();

			pst.close();
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void atualizarPaciente(Paciente paciente) {

		String sql = "update pacientes set nome = ?, telefone = ? where id = ?";

		try {

			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, paciente.getNome());
			pst.setString(2, paciente.getTelefone());
			

			pst.executeUpdate();

			pst.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Paciente pesquisarPorId(int id) {

		String sql = "select * from pacientes where id = ? ";

		Paciente paciente = null;

		try {
			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next() == true) {
				id = rs.getInt(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				
				paciente = new Paciente(id, nome, telefone);
			}

			rs.close();
			pst.close();
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return paciente;
	}

}