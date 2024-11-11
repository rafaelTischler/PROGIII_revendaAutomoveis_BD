package exercicio_revendaAutomoveis_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConexao() {
		try {
			return (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/bd_automoveis", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
