package DAO;


import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import biblio.Midias;



public  class MidiasDao implements Acervo<Midias>{
	
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(LivroDao.class);
	
	
	public MidiasDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}
	
	public void criar(Midias m) throws SQLException {
		
		PreparedStatement sql =null;
		try {
		 sql = conexion.prepareStatement("INSERT INTO midias VALUES(?,?,?)");
		 sql.setString(1,m.getTitulo());		
		 sql.setString(2,m.getTipo());
		 sql.setDate(3,m.getDtgravacao());
		 sql.execute();
		}catch(SQLException e){

			logger.error("erro na inser��o dos dados!");
			throw new SQLException(e.getMessage());
			
		}
		sql.close();
		conexion.close();
		
	}

	public void editar(String titulo_midia,String troca_titulo)throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("UPDATE midias	SET titulo = ?  WHERE titulo = ?");
			sql.setString(1, troca_titulo);
			sql.setString(2, titulo_midia);
		} catch (SQLException e) {
			logger.error("falha ao editar!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
	}
		

	public void pesquisar(String titulo_midia) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("SELECT * FROM midias WHERE titulo = ?");
			sql.setString(1, titulo_midia);
		} catch (SQLException e) {
			logger.error("falha na pesquisa!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
	}


	public void excluir(String titulo_midia) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("DELETE FROM midias WHERE titulo = ?");
			sql.setString(1, titulo_midia);
		} catch (SQLException e) {
			logger.error("falha!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
	}



}