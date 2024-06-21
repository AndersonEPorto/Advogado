package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conection.Conexao;
import model.ProcessoCivil;

public class ProcessoCivilDao {
	
	
	public void Inserir(ProcessoCivil processoCivil) {
		String sql = "INSERT INTO" + " processoCivil(id, numeroProcesso, dataInicio, partesEnvolvidas, valorCausa, faseProcesso) "
				+ "VALUES (?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmm = null;

		try {
			// conexao com DB
			conn = Conexao.getConnection();

			pstmm = conn.prepareStatement(sql);
			
			pstmm.setInt(1,  processoCivil.getIdProcessoCivil());
			pstmm.setString(2, processoCivil.getNumeroProcesso());
			pstmm.setString(3, processoCivil.getDataInicio());
			pstmm.setString(4, processoCivil.getPartesEnvolvidas());
			pstmm.setString(5, processoCivil.getValorCausa());
			pstmm.setString(6, processoCivil.getFaseProcesso());

			pstmm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public ArrayList<ProcessoCivil> listaProcessoCivil() {
			ArrayList<ProcessoCivil> processoCivil = new ArrayList<>();
			String read = "select * from processoCivil order by nome";
			Connection conn = null;
			PreparedStatement pstmm = null;
			try {
				// Abrir a conexão
				conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				pstmm = conn.prepareStatement(read);
				ResultSet rs = pstmm.executeQuery();

				// Enquanto houver ProcessoCivil será executado o laço
				while (rs.next()) {
					// Var de apoio que recebem os dados do banco
					int idProcessoCivil = rs.getInt(1);
					String numeroProcesso = rs.getString(2);
					String dataInicio = rs.getString(3);
					String partesEnvolvidas = rs.getString(4);
					String valorCausa = rs.getString(5);
					String faseProcesso = rs.getString(6);

					// Populando o ArrayList
					processoCivil.add(new ProcessoCivil(idProcessoCivil, numeroProcesso, dataInicio, partesEnvolvidas, valorCausa, faseProcesso));
				}
				
				conn.close();
				return processoCivil;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		// Seleionando o processoCivil por ID
		public void selecionarProcessoCivil(ProcessoCivil processoCivil) {
			String read = "select * from processoCivil where idProcessoCivil = ?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pstm = conn.prepareStatement(read);
				pstm.setLong(1, processoCivil.getIdProcessoCivil());
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {

					//(int idProcessoCivil, String numeroProcesso, String dataInicio, String partesEnvolvidas, String valorCausa, String faseProcesso)
					
					
					// Setando as variáveis de produto
					processoCivil.setIdProcessoCivil(rs.getInt(1));
					processoCivil.setNumeroProcesso(rs.getString(2));
					processoCivil.setDataInicio(rs.getString(3));
					processoCivil.setPartesEnvolvidas(rs.getString(4));
					processoCivil.setValorCausa(rs.getString(5));
					processoCivil.setFaseProcesso(rs.getString(6));
					
				
				}
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		// Editando o processoCivil
		public void alterarProcessoCivil(ProcessoCivil processoCivil) {
			String create = "update ProcessoCivil set nome=?, numeroOAB=?, especializacao=?, telefone=?, email=?, cep=?, logradouro=?, bairro=?, cidade=?, estado=? where idProcessoCivil=?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pstmm = conn.prepareStatement(create);
				pstmm.setInt(1,  processoCivil.getIdProcessoCivil());
				pstmm.setString(2, processoCivil.getNumeroProcesso());
				pstmm.setString(3, processoCivil.getDataInicio());
				pstmm.setString(4, processoCivil.getPartesEnvolvidas());
				pstmm.setString(5, processoCivil.getValorCausa());
				pstmm.setString(6, processoCivil.getFaseProcesso());

				pstmm.executeUpdate();
				
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/** DELETE **/
		public void deletarProcessoCivil(ProcessoCivil processoCivil) {
			String delete = "delete from ProcessoCivil where idProcessoCivil=?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pstm = conn.prepareStatement(delete);
				pstm.setInt(1, processoCivil.getIdProcessoCivil());
				pstm.executeUpdate();
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}


	

}
