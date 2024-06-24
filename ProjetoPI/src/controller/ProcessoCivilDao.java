package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conection.Conexao;
import model.ProcessoCivil;

public class ProcessoCivilDao {

	public void Inserir(ProcessoCivil procCivil) {
		String sql = "INSERT INTO processosciveis (numeroProcesso, dataInicio, partesEnvolvidas, tipoAcao, valorCausa, faseProcesso) VALUES (?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// conexao com DB
			conn = Conexao.getConnection();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, procCivil.getNumeroProcesso());
			pstm.setDate(2, procCivil.getDataInicio());
			pstm.setString(3, procCivil.getPartesEnvolvidas());
			pstm.setString(4, procCivil.getTipoAcao());
			pstm.setString(5, procCivil.getValorCausa());
			pstm.setString(6, procCivil.getFaseProcesso());

			pstm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ProcessoCivil> listaProcessosCiveis() {
		ArrayList<ProcessoCivil> processoCivil = new ArrayList<>();
		String read = "select * from processoCiveis order by idProcessosCiveis";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Abrir a conexão
			conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			pstm = conn.prepareStatement(read);
			ResultSet rs = pstm.executeQuery();

			// Enquanto houver processoCivil será executado o laço
			while (rs.next()) {
				// Var de apoio que recebem os dados do banco
				int idProcessoCiveis = rs.getInt(1);
				String numeroProcesso = rs.getString(2);
				Date dataInicio = rs.getDate(3);
				String partesEnvolvidas = rs.getString(4);
				String tipoAcao = rs.getString(5);
				String valorCausa = rs.getString(6);
				String faseProcesso = rs.getString(7);

				// Populando o ArrayList
				processoCivil.add(new ProcessoCivil(idProcessoCiveis, numeroProcesso, dataInicio, partesEnvolvidas, tipoAcao, valorCausa, faseProcesso));
			}
			conn.close();
			return processoCivil;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Seleionando o processoCivil por ID
	public void selecionarProcessoCivil(ProcessoCivil procCivil) {
		String read = "select * from processosCiveis where idProcessosCiveis = ?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(read);
			pst.setLong(1, procCivil.getIdProcessoCivil());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				// Setando as variáveis de produto
				procCivil.setIdProcessoCivil(rs.getInt(1));
				procCivil.setNumeroProcesso(rs.getString(2));
				procCivil.setDataInicio(rs.getDate(3));
				procCivil.setPartesEnvolvidas(rs.getNString(4));
				procCivil.setTipoAcao(rs.getNString(5));
				procCivil.setValorCausa(rs.getString(6));
				procCivil.setFaseProcesso(rs.getString(7));

			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Editando o ProcessoCivil
	public void alterarProcessoCivil(ProcessoCivil procCivil) {
		String create = "update processosciveis set  numeroProcessosPenais=?, dataInicio=?, nomeReu=?, tipoCrime=?, faseProcesso=?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, procCivil.getNumeroProcesso());
			pst.setDate(2, procCivil.getDataInicio());
			pst.setString(3, procCivil.getPartesEnvolvidas());
			pst.setString(4, procCivil.getTipoAcao());
			pst.setString(5, procCivil.getValorCausa());
			pst.setString(6, procCivil.getFaseProcesso());

			pst.executeUpdate();

			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//DELETE ProcessoCivil
	public void deletarProcessoCivil(ProcessoCivil procCivil) {
		String delete = "delete from processosciveis where idProcessosCiveis=?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(delete);
			pst.setInt(1, procCivil.getIdProcessoCivil());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
