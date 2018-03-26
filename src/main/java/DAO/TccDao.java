package DAO;


import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import biblio.Tcc;




public  class TccDao implements Acervo<Tcc> {
	
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(LivroDao.class);
	
	
	public TccDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}
	
	public void criar(Tcc t) throws SQLException{
		
		PreparedStatement sql =null;
		
		try {
		 sql = conexion.prepareStatement("INSERT INTO tcc VALUES(?,?,?,?,?)");
		 sql.setString(1,t.getTitulo());		
		 sql.setString(2,t.getAutor());
		 sql.setString(3,t.getOrientador());
		 sql.setString(4,t.getTipo());
		 sql.setInt(5,t.getAnodefesa());
		 sql.setString(6,t.getLocal());
		 sql.execute();
		 
		}catch(SQLException e){
			
			logger.error("erro na inserção dos dados! "+e);
			//throw new SQLException(e.getMessage());
			
		}
		sql.close();
		conexion.close();
	}

	public void editar(String titulo_tcc,String troca_titulo)throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("UPDATE tcc	SET titulo = ?  WHERE titulo = ?");
			sql.setString(1, troca_titulo);
			sql.setString(2, titulo_tcc);
		} catch (SQLException e) {
			logger.error("falha ao editar!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
	}
		

	public void pesquisar(String titulo_tcc) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("SELECT * FROM tcc WHERE titulo = ?");
			sql.setString(1, titulo_tcc);
		} catch (SQLException e) {
			logger.error("falha na pesquisa!");
			e.printStackTrace();
		}
		
		sql.close();
		conexion.close();
	}


	public void excluir(String titulo_tcc) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("DELETE FROM tcc WHERE titulo = ?");
			sql.setString(1, titulo_tcc);
		} catch (SQLException e) {
			logger.error("falha!");
			e.printStackTrace();
		}
		
		sql.close();
		conexion.close();
		
	}



}