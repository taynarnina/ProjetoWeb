package br.edu.ufab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConnectionFactory {
	
	private static String url = "jdbc:mysql://localhost:3306/biblioteca_ufab";
	private static String user = "root";
	private static String password = "";
	private static Connection connection = null;
	private static final Logger logger = LogManager.getLogger(ConnectionFactory.class);
	
	public static Connection getConnection() {
		try	{
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url,user,password);
			return connection;
		}catch	(SQLException | ClassNotFoundException	e)	{
			logger.error("N�o foi possivel conectar ao banco de Dados",e);
		}
		return connection;
	}
}