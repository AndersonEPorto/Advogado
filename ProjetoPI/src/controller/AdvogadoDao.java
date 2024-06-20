package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conection.Conexao;
import model.Advogado;

public class AdvogadoDao {
	
	public void Inserir(Advogado advogado) {
		String sql = "INSERT INTO Advogados(nome, numeroOAB, especializacao, telefone, email, cep, logradouro, bairro, cidade, estado) VALUES (?,?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// conexao com DB
			conn = Conexao.getConnection();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, advogado.getNome());
			pstm.setString(2, advogado.getNumeroOAB());
			pstm.setString(3, advogado.getEspecializacao());
			pstm.setString(4, advogado.getTelefone());
			pstm.setString(5, advogado.getEmail());
			pstm.setString(6, advogado.getCep());
			pstm.setString(7, advogado.getLogradouro());
			pstm.setString(8, advogado.getBairro());
			pstm.setString(9, advogado.getCidade());
			pstm.setString(10, advogado.getEstado());

			pstm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public ArrayList<Advogado> listaAdvogados() {
			ArrayList<Advogado> advogados = new ArrayList<>();
			String read = "select * from advogados order by nome";
			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				// Abrir a conexão
				conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				pstm = conn.prepareStatement(read);
				ResultSet rs = pstm.executeQuery();

				// Enquanto houver Advogados será execuçtado o laço
				while (rs.next()) {
					// Var de apoio que recebem os dados do banco
					int idAdvogado = rs.getInt(1);
					String nome = rs.getString(2);
					String numeroOAB = rs.getString(3);
					String especializacao = rs.getString(4);
					String telefone = rs.getString(5);
					String email = rs.getString(6);
					String cep = rs.getString(7);
					String logradouro = rs.getString(8);
					String bairro = rs.getString(9);
					String cidade = rs.getString(10);
					String estado = rs.getString(11);
					// Populando o ArrayList
					advogados.add(new Advogado(idAdvogado, nome, numeroOAB, especializacao, telefone, email, cep, logradouro, bairro, cidade, estado));
				}
				conn.close();
				return advogados;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		// Seleionando o advogado por ID
		public void selecionarAdvogado(Advogado advogado) {
			String read = "select * from advogado where idAdvogado = ?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pst = conn.prepareStatement(read);
				pst.setLong(1, advogado.getIdAdvogado());
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {

					// Setando as variáveis de produto
					advogado.setIdAdvogado(rs.getInt(1));
					advogado.setNome(rs.getString(2));
					advogado.setNumeroOAB(rs.getString(3));
					advogado.setEspecializacao(rs.getString(4));
					advogado.setTelefone(rs.getString(5));
					advogado.setEmail(rs.getString(6));
					advogado.setCep(rs.getString(7));
					advogado.setLogradouro(rs.getString(8));
					advogado.setBairro(rs.getString(9));
					advogado.setCidade(rs.getString(10));
					advogado.setEstado(rs.getString(11));
				
				}
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		// Editando o advogado
		public void alterarAdvogado(Advogado advogado) {
			String create = "update Advogados set nome=?, numeroOAB=?, especializacao=?, telefone=?, email=?, cep=?, logradouro=?, bairro=?, cidade=?, estado=? where idAdvogado=?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pst = conn.prepareStatement(create);
				pst.setString(1, advogado.getNome());
				pst.setString(2, advogado.getNumeroOAB());
				pst.setString(3, advogado.getEspecializacao());
				pst.setString(4, advogado.getTelefone());
				pst.setString(5, advogado.getEmail());
				pst.setString(6, advogado.getCep());
				pst.setString(7, advogado.getLogradouro());
				pst.setString(8, advogado.getBairro());
				pst.setString(9, advogado.getCidade());
				pst.setString(10, advogado.getEstado());
				pst.setInt(11, advogado.getIdAdvogado());
				pst.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/** DELETE **/
		public void deletarAdvogado(Advogado advogado) {
			String delete = "delete from Advogados where idAdvogado=?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pst = conn.prepareStatement(delete);
				pst.setInt(1, advogado.getIdAdvogado());
				pst.executeUpdate();
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}


	

}
