package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conection.Conexao;
import model.ProcessoPrevidencia;

public class ProcessoPrevidenciaDao {
	
	public void Inserir(ProcessoPrevidencia procPrevidencia) {
		String sql = "INSERT INTO processosprevidenciarios (numeroProcesso,dataInicio,partesEnvolvidas,tipoAcao,faseProcesso) VALUES (?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// conexao com DB
			conn = Conexao.getConnection();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, procPrevidencia.getNumeroProcesso());
			pstm.setDate(2, procPrevidencia.getDataInicio());
			pstm.setString(3, procPrevidencia.getParetesEnvolvidas());
			pstm.setString(4, procPrevidencia.getTipoAcao());
			pstm.setString(5, procPrevidencia.getFaseProcesso());

			pstm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ProcessoPrevidencia> listaProcessoPrevidencia() {
		ArrayList<ProcessoPrevidencia> processoPrevidencia = new ArrayList<>();
		String read = "select * from processosPrevidenciaios order by idProcessosPrevidenciarios";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Abrir a conexão
			conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			pstm = conn.prepareStatement(read);
			ResultSet rs = pstm.executeQuery();

			// Enquanto houver ProcessoPrevidencia será executado o laço
			while (rs.next()) {
				// Var de apoio que recebem os dados do banco
				int idProcessosPrevidenciarios = rs.getInt(1);
				String numeroProcesso = rs.getString(2);
				Date dataInicio = rs.getDate(3);
				String partesEnvolvidas = rs.getString(4);
				String tipoAcao = rs.getString(5);
				String faseProcesso = rs.getString(6);

				// Populando o ArrayList
				processoPrevidencia.add(new ProcessoPrevidencia(idProcessosPrevidenciarios, numeroProcesso, dataInicio, partesEnvolvidas, tipoAcao, faseProcesso));
			}
			conn.close();
			return processoPrevidencia;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Seleionando o ProcessoPrevidencia por ID
	public void selecionarProcessoPrevidencia(ProcessoPrevidencia ProcPrevidencia) {
		String read = "select * from processosprevidenciarios where idProcessosPrevidenciarios = ?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(read);
			pst.setLong(1, ProcPrevidencia.getIdProcessoPrevidencia());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				// Setando as variáveis de produto
				ProcPrevidencia.setIdProcessoPrevidencia(1);
				ProcPrevidencia.setNumeroProcesso(rs.getString(2));
				ProcPrevidencia.setDataInicio(rs.getDate(3));
				ProcPrevidencia.setParetesEnvolvidas(rs.getString(4));
				ProcPrevidencia.setTipoAcao(rs.getString(5));
				ProcPrevidencia.setFaseProcesso(rs.getString(6));

			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Editando o ProcessoPrevidencia
	public void alterarProcessoPrevidencia(ProcessoPrevidencia ProcPrevidencia) {
		String create = "update processosprevidenciarios set  numeroProcessosPenais=?, dataInicio=?, nomeReu=?, tipoCrime=?, faseProcesso=?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, ProcPrevidencia.getNumeroProcesso());
			pst.setDate(2, ProcPrevidencia.getDataInicio());
			pst.setString(3, ProcPrevidencia.getParetesEnvolvidas());
			pst.setString(4, ProcPrevidencia.getTipoAcao());
			pst.setString(5, ProcPrevidencia.getFaseProcesso());

			pst.executeUpdate();

			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//DELETE ProcessoPrevidencia
	public void deletarProcessoPrevidencia(ProcessoPrevidencia ProcPrevidencia) {
		String delete = "delete from processosprevidenciarios where idProcessosPrevidenciarios=?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(delete);
			pst.setInt(1, ProcPrevidencia.getIdProcessoPrevidencia());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
