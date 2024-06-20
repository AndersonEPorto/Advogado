package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conection.Conexao;
import model.ClienteFisico;

public class ClienteFisicoDao {
	
	public void Inserir(ClienteFisico clienteFisico) {
		String sql = "INSERT INTO" + " clienteFisico(nome, telefone, cep, logradouro, bairro, estado, idClienteFisico, rg) "
				+ "VALUES (?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmm = null;

		try {
			// conexao com DB
			conn = Conexao.getConnection();

			pstmm = conn.prepareStatement(sql);
			
			pstmm.setString(1, clienteFisico.getNome());
			pstmm.setString(2, clienteFisico.getTelefone());
			pstmm.setString(3, clienteFisico.getCep());
			pstmm.setString(4, clienteFisico.getLogradouro());
			pstmm.setString(5, clienteFisico.getBairro());
			pstmm.setString(6, clienteFisico.getEstado());
			pstmm.setInt(7, clienteFisico.getIdClienteFisico());
			pstmm.setString(8, clienteFisico.getRg());

			pstmm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public ArrayList<ClienteFisico> listaClienteFisicos() {
			ArrayList<ClienteFisico> clienteFisicos = new ArrayList<>();
			String read = "select * from clienteFisicos order by nome";
			Connection conn = null;
			PreparedStatement pstmm = null;
			try {
				// Abrir a conexão
				conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				pstmm = conn.prepareStatement(read);
				ResultSet rs = pstmm.executeQuery();

				// Enquanto houver ClienteFisicos será executado o laço
				while (rs.next()) {
					// Var de apoio que recebem os dados do banco
					int idClienteFisico = rs.getInt(1);
					String nome = rs.getString(2);
					String telefone = rs.getString(3);
					String cep = rs.getString(4);
					String logradouro = rs.getString(5);
					String bairro = rs.getString(6);
					String estado = rs.getString(7);
					String rg = rs.getString(8);
					// Populando o ArrayList
					clienteFisicos.add(new ClienteFisico(idClienteFisico, nome, telefone, cep, logradouro, bairro, estado, idClienteFisico, rg));
				}
				conn.close();
				return clienteFisicos;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		// Seleionando o clienteFisico por ID
		public void selecionarClienteFisico(ClienteFisico clienteFisico) {
			String read = "select * from clienteFisico where idClienteFisico = ?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pstm = conn.prepareStatement(read);
				pstm.setLong(1, clienteFisico.getIdClienteFisico());
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {

					// Setando as variáveis de produto
					clienteFisico.setIdClienteFisico(rs.getInt(1));
					clienteFisico.setNome(rs.getString(2));
					clienteFisico.setTelefone(rs.getString(3));
					clienteFisico.setCep(rs.getString(4));
					clienteFisico.setLogradouro(rs.getString(5));
					clienteFisico.setBairro(rs.getString(6));
					clienteFisico.setEstado(rs.getString(7));
					clienteFisico.setRg(rs.getString(8));
					
				
				}
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		// Editando o clienteFisico
		public void alterarClienteFisico(ClienteFisico clienteFisico) {
			String create = "update ClienteFisicos set nome=?, numeroOAB=?, especializacao=?, telefone=?, email=?, cep=?, logradouro=?, bairro=?, cidade=?, estado=? where idClienteFisico=?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pstmm = conn.prepareStatement(create);
				pstmm.setString(1, clienteFisico.getNome());
				pstmm.setString(2, clienteFisico.getTelefone());
				pstmm.setString(3, clienteFisico.getCep());
				pstmm.setString(4, clienteFisico.getLogradouro());
				pstmm.setString(5, clienteFisico.getBairro());
				pstmm.setString(6, clienteFisico.getEstado());
				pstmm.setInt(7, clienteFisico.getIdClienteFisico());
				pstmm.setString(8, clienteFisico.getRg());
				pstmm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/** DELETE **/
		public void deletarClienteFisico(ClienteFisico clienteFisico) {
			String delete = "delete from ClienteFisicos where idClienteFisico=?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pstm = conn.prepareStatement(delete);
				pstm.setInt(1, clienteFisico.getIdClienteFisico());
				pstm.executeUpdate();
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}


	

}
