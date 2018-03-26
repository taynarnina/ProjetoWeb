package DAO;


import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import biblio.Jornal;

public  class JornalDao implements Acervo<Jornal> {
	
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(LivroDao.class);
	
	
	public JornalDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}
	
	public void criar(Jornal j) throws SQLException {
		
		PreparedStatement sql =null;
		try {
		 sql = conexion.prepareStatement("INSERT INTO jornal VALUES(?,?,?)");
		 sql.setString(1,j.getTitulo());		
		 sql.setDate(2,j.getDtpublic());
		 sql.setLong(3,j.getEdicao());
		 sql.execute();
		}catch(SQLException e){
			logger.error("erro na inserção dos dados!");
			throw new SQLException(e.getMessage());
			
		}
		sql.close();
		conexion.close();
		
	}

	public void editar(String titulo_jornal,String troca_titulo)throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("UPDATE jornal	SET titulo = ?  WHERE titulo = ?");
			sql.setString(1, troca_titulo);
			sql.setString(2, titulo_jornal);
		} catch (SQLException e) {
			logger.error("falha ao editar!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
	}
		

	public void pesquisar(String titulo_jornal) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("SELECT * FROM jornal WHERE titulo = ?");
			sql.setString(1, titulo_jornal);
		} catch (SQLException e) {
			logger.error("falha na pesquisa!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
	}


	public void excluir(String titulo_jornal) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("DELETE FROM jornal WHERE titulo = ?");
			sql.setString(1, titulo_jornal);
		} catch (SQLException e) {
			logger.error("falha!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
	}



}
