package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;

public class Conexao {
	
	private static String user = "root";
	private static String password = "root";
	private static final Logger logger = LogManager.getLogger(Conexao.class);
	
	
	public static Connection fazconexao() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return (Connection) DriverManager.getConnection("jdbc:mysql://Local instance MySQL57/biblio_ufab",user,password);
		}catch(ClassNotFoundException e){
			logger.error("falha na conexao");
			throw new SQLException(e.getException());	
			
		}
	}

}
