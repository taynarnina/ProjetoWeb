package br.edu.ufab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 * Classe que faz conexão das classes dao com o banco de dados.
 * 
 * @author Taynar Sousa e Murilo Gustavo
 * */

public class ConnectionFactory {
	
	private static String url = "jdbc:mysql://localhost:3306/biblioteca_ufab";
	private static String user = "root";
	private static String password = "root";
	private static Connection connection = null;
	private static final Logger logger = LogManager.getLogger(ConnectionFactory.class);
	/**
	 * Método que vai gerar a conexão com o banco de dados
	 * 
	 * */
	public static Connection getConnection() {
		try	{
			logger.info("iniciando conexão...");
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url,user,password);
			logger.info("conexão iniciada!");
			return connection;
		}catch	(SQLException | ClassNotFoundException	e)	{
			logger.error("Não foi possivel conectar ao banco de Dados",e);
		}
		return connection;
	}
}
