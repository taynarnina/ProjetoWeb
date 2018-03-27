package DAO;


import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Date;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import biblio.Jornal;

public  class JornalDao implements Acervo<Jornal> {
	
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(LivroDao.class);
	private static Date d;
	
	
	
	public JornalDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}
	
	public boolean criar(Jornal j) throws SQLException {
		
		PreparedStatement sql =null;
		String dataString = j.getDtpublic();
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date d = null;
		try {
			d = new java.sql.Date(fmt.parse(dataString).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
		 sql = conexion.prepareStatement("INSERT INTO jornal(titulo,data,edicao) VALUES(?,?,?)");
		 sql.setString(1,j.getTitulo());		
		 sql.setDate(2, d);
		 sql.setLong(3,j.getEdicao());
		 sql.execute();
		 System.out.println("inserido");
		 
		 sql.close();
		 conexion.close();
		
		 return true;
		}catch(SQLException e){
			
			logger.error(e.getMessage());
			
		}
		sql.close();
		conexion.close();
		return false;
	}

	public boolean editar(String titulo_jornal,String troca_titulo)throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("UPDATE jornal SET titulo = ? WHERE titulo = ?");
			sql.setString(1, troca_titulo);
			sql.setString(2, titulo_jornal);
			sql.execute();
			System.out.println("alterado");
			
			sql.close();
			conexion.close();
			
			return true;
		} catch (SQLException e) {
			logger.error("falha ao editar!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
		return false;
	}
		

	public boolean pesquisar(String titulo_jornal) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("SELECT * FROM jornal WHERE titulo = ?");
			sql.setString(1, titulo_jornal);
			sql.execute();
			System.out.println("eu encontrei");
			
			sql.close();
			conexion.close();
			
			return true;
		} catch (SQLException e) {
			logger.error("falha na pesquisa!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
		return false;
	}

	public boolean excluir(String titulo_jornal) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("DELETE FROM jornal WHERE titulo = ?");
			sql.setString(1, titulo_jornal);
			sql.execute();
			System.out.println("excluido");
			
			sql.close();
			conexion.close();
			
			return true;
		} catch (SQLException e) {
			logger.error("falha!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
		return false;
	}
}
