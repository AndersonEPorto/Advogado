package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conection.Conexao;
import model.ClienteJuridico;

public class ClienteJuridicoDao {

	public void Inserir(ClienteJuridico clienteJuridico) {
		String sql = "INSERT INTO" + " clienteJuridico(nome, telefone, cep, logradouro, bairro, cidade, estado, cnpj, razaosocial) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmm = null;

		try {
			// conexao com DB
			conn = Conexao.getConnection();

			pstmm = conn.prepareStatement(sql);
			
			pstmm.setString(1, clienteJuridico.getNome());
			pstmm.setString(2, clienteJuridico.getTelefone());
			pstmm.setString(3, clienteJuridico.getCep());
			pstmm.setString(4, clienteJuridico.getLogradouro());
			pstmm.setString(5, clienteJuridico.getBairro());
			pstmm.setString(6, clienteJuridico.getCidade());
			pstmm.setString(7, clienteJuridico.getEstado());
			pstmm.setString(8, clienteJuridico.getCnpj());
			pstmm.setString(9, clienteJuridico.getRazaoSocial());

			pstmm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public ArrayList<ClienteJuridico> listaClienteJuridico() {
			ArrayList<ClienteJuridico> clienteJuridico = new ArrayList<>();
			String read = "select * from clienteJuridico order by nome";
			Connection conn = null;
			PreparedStatement pstmm = null;
			try {
				// Abrir a conexão
				conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				pstmm = conn.prepareStatement(read);
				ResultSet rs = pstmm.executeQuery();

				// Enquanto houver ClienteJuridico será executado o laço
				while (rs.next()) {
					// Var de apoio que recebem os dados do banco
					int idClienteJuridico = rs.getInt(1);
					String nome = rs.getString(2);
					String telefone = rs.getString(3);
					String cep = rs.getString(4);
					String logradouro = rs.getString(5);
					String bairro = rs.getString(6);
					String cidade = rs.getString(7);
					String estado = rs.getString(8);
					
					//-->Rever o processo de herança 
					String cnpj = rs.getString(9);
					String razaosocial = rs.getString(10);
					
					// Populando o ArrayList
					clienteJuridico.add(new ClienteJuridico(idClienteJuridico, nome, telefone, telefone, cep, logradouro, bairro, cidade, estado, idClienteJuridico, cnpj, razaosocial));
				}
				conn.close();
				return clienteJuridico;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		// Seleionando o ClienteJuridico por ID
		public void selecionarClienteFisico(ClienteJuridico clienteJuridico) {
			String read = "select * from clienteJuridico where idClienteJuridico = ?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pstm = conn.prepareStatement(read);
				pstm.setLong(1, clienteJuridico.getIdClienteJuridico());
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {

					// Setando as variáveis de produto
					clienteJuridico.setIdClienteJuridico(rs.getInt(1));
					clienteJuridico.setNome(rs.getString(2));
					clienteJuridico.setTelefone(rs.getString(3));
					clienteJuridico.setEmail(rs.getString(4));
					clienteJuridico.setCep(rs.getString(5));
					clienteJuridico.setLogradouro(rs.getString(6));
					clienteJuridico.setBairro(rs.getString(7));
					clienteJuridico.setCidade(rs.getString(8));
					clienteJuridico.setEstado(rs.getString(9));
					clienteJuridico.setCnpj(rs.getString(10));
					clienteJuridico.setRazaoSocial(rs.getString(11));
					
				
				}
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		// Editando o ClienteJuridico
		public void alterarClienteFisico(ClienteJuridico clienteJuridico) {
			String create = "update clienteJuridico set nome=?, telefone=?, email=?, cep=?, logradouro=?, bairro=?, cidade=?, estado=?, cnpj=?, razaosocial=? where idClienteFisico=?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pstmm = conn.prepareStatement(create);
				pstmm.setString(1, clienteJuridico.getNome());
				pstmm.setString(2, clienteJuridico.getTelefone());
				pstmm.setString(3, clienteJuridico.getEmail());
				pstmm.setString(4, clienteJuridico.getCep());
				pstmm.setString(5, clienteJuridico.getLogradouro());
				pstmm.setString(6, clienteJuridico.getBairro());
				pstmm.setString(7, clienteJuridico.getCidade());
				pstmm.setString(8, clienteJuridico.getEstado());
				pstmm.setString(10, clienteJuridico.getCnpj());
				pstmm.setString(11, clienteJuridico.getRazaoSocial());
				pstmm.setInt(12, clienteJuridico.getIdClienteJuridico());

				pstmm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/** DELETE **/
		public void deletarClienteFisico(ClienteJuridico clienteJuridico) {
			String delete = "delete from clienteJuridico where idClienteJuridico=?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pstm = conn.prepareStatement(delete);
				pstm.setInt(1, clienteJuridico.getIdClienteJuridico());
				pstm.executeUpdate();
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	
}
