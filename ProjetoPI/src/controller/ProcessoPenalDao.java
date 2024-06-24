package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conection.Conexao;
import model.ProcessoPenal;

public class ProcessoPenalDao {

	public void Inserir(ProcessoPenal procPenal) {
		String sql = "INSERT INTO processospenais (numeroProcesso,dataInicio,nomeReu,tipoCrime,getFaseProcesso) VALUES (?,?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// conexao com DB
			conn = Conexao.getConnection();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, procPenal.getNumeroProcesso());
			pstm.setDate(2, procPenal.getDataInicio());
			pstm.setString(3, procPenal.getNomeReu());
			pstm.setString(4, procPenal.getTipoCrime());
			pstm.setString(5, procPenal.getFaseProcesso());

			pstm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ProcessoPenal> listaProcessosPenais() {
		ArrayList<ProcessoPenal> processoPenal = new ArrayList<>();
		String read = "select * from processospenais order by idProcessosPenais";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Abrir a conexão
			conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			pstm = conn.prepareStatement(read);
			ResultSet rs = pstm.executeQuery();

			// Enquanto houver Advogados será executado o laço
			while (rs.next()) {
				// Var de apoio que recebem os dados do banco
				int idProcessosPenais = rs.getInt(1);
				String numeroProcesso = rs.getString(2);
				Date dataInicio = rs.getDate(3);
				String nomeReu = rs.getString(4);
				String tipoCrime = rs.getString(5);
				String faseProcesso = rs.getString(6);

				// Populando o ArrayList
				processoPenal.add(new ProcessoPenal(idProcessosPenais, numeroProcesso, dataInicio, nomeReu, tipoCrime,
						faseProcesso));
			}
			conn.close();
			return processoPenal;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Seleionando o procPenal por ID
	public void selecionarProcessoPenal(ProcessoPenal procPenal) {
		String read = "select * from processosPenais where idProcessosPenais = ?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(read);
			pst.setLong(1, procPenal.getIdProcessoPenais());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				// Setando as variáveis de produto
				procPenal.setIdProcessoPenais(rs.getInt(1));
				procPenal.setNumeroProcesso(rs.getString(2));
				procPenal.setDataInicio(rs.getDate(3));
				procPenal.setNomeReu(rs.getString(4));
				procPenal.setTipoCrime(rs.getString(5));
				procPenal.setFaseProcesso(rs.getString(6));

			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Editando o procPenal
	public void alterarProcessoPenal(ProcessoPenal procPenal) {
		String create = "update processospenais set  numeroProcessosPenais=?, dataInicio=?, nomeReu=?, tipoCrime=?, faseProcesso=?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, procPenal.getNumeroProcesso());
			pst.setDate(2, procPenal.getDataInicio());
			pst.setString(3, procPenal.getNomeReu());
			pst.setString(4, procPenal.getTipoCrime());
			pst.setString(5, procPenal.getFaseProcesso());

			pst.executeUpdate();

			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//DELETE procPenal
	public void deletarProcessoPenal(ProcessoPenal procPenal) {
		String delete = "delete from processospenais where idProcessosPenais=?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(delete);
			pst.setInt(1, procPenal.getIdProcessoPenais());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
