package conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	// Drive
	static String driver = "com.mysql.cj.jdbc.Driver";
	// Usuario
	private static String usuario = "root";

	// Senha
	private static String senha = "root6406";

	// URL
	private static String url = "jdbc:mysql://localhost:3306/escritorioAdvg";

	/*
	 * Conexão com banco de dados
	 */

	public static Connection getConnection() throws Exception {
		// Faz com que a classe seja carregada pela JVM
		Class.forName(driver);

		// Cria a conexão com banco de dados
		Connection connection = DriverManager.getConnection(url, usuario, senha);

		return connection;
	}

}
