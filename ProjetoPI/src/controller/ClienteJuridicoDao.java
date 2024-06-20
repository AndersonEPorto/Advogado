package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conection.Conexao;
import model.ClienteJuridico;

public class ClienteJuridicoDao {
	
	
	public void Inserir(ClienteJuridico clienteJuridico) {
		String sql = "INSERT INTO" + " clienteJuridico(nome, telefone, cep, logradouro, bairro, estado, idClienteJuridico, cnpj, razaoSocial) "
				+ "VALUES (?,?,?,?,?,?,?,?.?)";

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
			pstmm.setString(6, clienteJuridico.getEstado());
			pstmm.setInt(7, clienteJuridico.getIdClienteJuridico());
			pstmm.setString(8, clienteJuridico.getCnpj());
			pstmm.setString(9, clienteJuridico.getRazaoSocial());

			pstmm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public ArrayList<ClienteJuridico> listaClientesJuridico() {
			ArrayList<ClienteJuridico> clientesJuridico = new ArrayList<>();
			String read = "select * from clientesJuridico order by nome";
			Connection conn = null;
			PreparedStatement pstmm = null;
			try {
				// Abrir a conexão
				conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				pstmm = conn.prepareStatement(read);
				ResultSet rs = pstmm.executeQuery();

				// Enquanto houver ClientesJuridico será executado o laço
				while (rs.next()) {
					// Var de apoio que recebem os dados do banco
					int idClienteJuridico = rs.getInt(1);
					String nome = rs.getString(2);
					String telefone = rs.getString(3);
					String cep = rs.getString(4);
					String logradouro = rs.getString(5);
					String bairro = rs.getString(6);
					String estado = rs.getString(7);
					String cnpj = rs.getString(8);
					String razaoSocial = rs.getString(9);
					// Populando o ArrayList
					clientesJuridico.add(new ClienteJuridico(idClienteJuridico, nome, telefone, cep, logradouro, bairro, estado, idClienteJuridico, cnpj, razaoSocial));
				}
				conn.close();
				return clientesJuridico;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		// Seleionando o clienteJuridico por ID
		public void selecionarClienteJuridico(ClienteJuridico clienteJuridico) {
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
					clienteJuridico.setCep(rs.getString(4));
					clienteJuridico.setLogradouro(rs.getString(5));
					clienteJuridico.setBairro(rs.getString(6));
					clienteJuridico.setEstado(rs.getString(7));
					clienteJuridico.setCnpj(rs.getString(8));
					clienteJuridico.setRazaoSocial(rs.getString(9));
					
					
				}
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		// Editando o clienteJuridico
		public void alterarClienteJuridico(ClienteJuridico clienteJuridico) {
			String create = "update ClientesJuridico set nome=?, numeroOAB=?, especializacao=?, telefone=?, email=?, cep=?, logradouro=?, bairro=?, cidade=?, estado=? where idClienteJuridico=?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pstmm = conn.prepareStatement(create);
				pstmm.setString(1, clienteJuridico.getNome());
				pstmm.setString(2, clienteJuridico.getTelefone());
				pstmm.setString(3, clienteJuridico.getCep());
				pstmm.setString(4, clienteJuridico.getLogradouro());
				pstmm.setString(5, clienteJuridico.getBairro());
				pstmm.setString(6, clienteJuridico.getEstado());
				pstmm.setInt(7, clienteJuridico.getIdClienteJuridico());
				pstmm.setString(8, clienteJuridico.getCnpj());
				pstmm.setString(9, clienteJuridico.getRazaoSocial());
				pstmm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/** DELETE **/
		public void deletarClienteJuridico(ClienteJuridico clienteJuridico) {
			String delete = "delete from ClientesJuridico where idClienteJuridico=?";
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
