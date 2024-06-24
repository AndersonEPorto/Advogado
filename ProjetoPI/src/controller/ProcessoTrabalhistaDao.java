package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conection.Conexao;
import model.ProcessoTrabalhista;

public class ProcessoTrabalhistaDao {

	public void Inserir(ProcessoTrabalhista procTrabalhista) {
		String sql = "INSERT INTO processostrabalhistas (numeroProcesso,reclamante,tipoAcao,valorReivindicado,faseProcesso,dataInicio) VALUES (?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// conexao com DB
			conn = Conexao.getConnection();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, procTrabalhista.getNumeroProcesso());
			pstm.setString(2, procTrabalhista.getReclamante());
			pstm.setString(3, procTrabalhista.getTipoAcao());
			pstm.setString(4, procTrabalhista.getValorReivindicado());
			pstm.setString(5, procTrabalhista.getFaseProcesso());
			pstm.setDate(6, procTrabalhista.getDataInicio());

			pstm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ProcessoTrabalhista> listaProcessoTrabalhista() {
		ArrayList<ProcessoTrabalhista> processoTrabalhista = new ArrayList<>();
		String read = "select * from processostrabalhistas order by idProcessosTrabalhistas";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Abrir a conexão
			conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			pstm = conn.prepareStatement(read);
			ResultSet rs = pstm.executeQuery();

			// Enquanto houver processoTrabalhista será executado o laço
			while (rs.next()) {
				// Var de apoio que recebem os dados do banco
				int idProcessoTrabalhista = rs.getInt(1);
				String numeroProcesso = rs.getString(2);
				String reclamante = rs.getString(3);
				String tipoAcao = rs.getString(4);
				String valorReivindicado = rs.getString(5);
				String faseProcesso = rs.getString(6);
				Date dataInicio = rs.getDate(7);

				// Populando o ArrayList
				processoTrabalhista.add(new ProcessoTrabalhista(idProcessoTrabalhista, numeroProcesso, reclamante, tipoAcao, valorReivindicado, faseProcesso, dataInicio));
			}
			conn.close();
			return processoTrabalhista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Seleionando o ProcessoTrabalhista por ID
	public void selecionarProcessoTrabalhista(ProcessoTrabalhista procTrabalhista) {
		String read = "select * from processostrabalhistas where idProcessosTrabalhistas = ?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(read);
			pst.setLong(1, procTrabalhista.getIdProcesso());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				// Setando as variáveis de produto
				procTrabalhista.setIdProcesso(rs.getInt(1));
				procTrabalhista.setNumeroProcesso(rs.getString(2));
				procTrabalhista.setReclamante(rs.getString(3));
				procTrabalhista.setValorReivindicado(rs.getString(4));
				procTrabalhista.setFaseProcesso(rs.getString(5));
				procTrabalhista.setDataInicio(rs.getDate(6));

			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Editando o ProcPrevidencia
	public void alterarProcessoTrabalhista(ProcessoTrabalhista procTrabalhista) {
		String create = "update processostrabalhistas set  numeroProcessosPenais=?, reclamante=?, tipoAcao=?, valorReivindicado=?, faseProcesso=?, dataInicio=?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, procTrabalhista.getNumeroProcesso());
			pst.setString(2, procTrabalhista.getReclamante());
			pst.setString(3, procTrabalhista.getTipoAcao());
			pst.setString(4, procTrabalhista.getValorReivindicado());
			pst.setString(5, procTrabalhista.getFaseProcesso());
			pst.setDate(6, procTrabalhista.getDataInicio());

			pst.executeUpdate();

			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//DELETE ProcessoTrabalhista
	public void deletarProcessoTrabalhista(ProcessoTrabalhista procTrabalhista) {
		String delete = "delete from processostrabalhistas where idProcessosTrabalhistas=?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(delete);
			pst.setInt(1, procTrabalhista.getIdProcesso());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
}
