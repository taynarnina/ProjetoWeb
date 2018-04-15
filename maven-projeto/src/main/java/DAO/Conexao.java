package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;

public class Conexao {
	
	private static String url = "jdbc:mysql://localhost:3306/biblio_ufab";
	private static String user = "root";
	private static String password = "";
	private static Connection con = null;
	private static final Logger logger = LogManager.getLogger(Conexao.class);
	
	
	public static Connection fazconexao() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url,user,password);
			return con;
		}catch(ClassNotFoundException e){
			logger.error("erro na comunicação com o BD");
			throw new SQLException(e.getException());	
			
		}
	}

}
