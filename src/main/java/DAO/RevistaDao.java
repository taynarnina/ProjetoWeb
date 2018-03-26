package DAO;


import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import biblio.Revista;



public  class RevistaDao implements Acervo<Revista> {
	
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(LivroDao.class);
	
	
	public RevistaDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}
	
	public void criar(Revista r) throws SQLException {
		
		PreparedStatement sql =null;
		try {
		 sql = conexion.prepareStatement("INSERT INTO livro VALUES(?,?,?,?,?)");
		 sql.setString(1,r.getTitulo());		
		 sql.setString(2,r.getEditora());
		 sql.setDate(3,r.getDtpublicacao());
		 sql.setInt(4,r.getEdicao());
		 sql.setInt(5,r.getNumpaginas());
		 sql.execute();
		}catch(SQLException e){
			logger.error("erro na inserção dos dados!");
			
			
		}
		sql.close();
		conexion.close();
		
	}

	public void editar(String titulo_revista,String troca_titulo)throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("UPDATE revista SET titulo = ?  WHERE titulo = ?");
			sql.setString(1, troca_titulo);
			sql.setString(2, titulo_revista);
		} catch (SQLException e) {
			logger.error("falha ao editar!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
		
	}
		

	public void pesquisar(String titulo_revista) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("SELECT * FROM revista WHERE titulo = ?");
			sql.setString(1, titulo_revista);
		} catch (SQLException e) {
			logger.error("falha na pesquisa!");
			e.printStackTrace();
			
		}
		sql.close();
		conexion.close();
	}


	public void excluir(String titulo_revista) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("DELETE FROM revista WHERE titulo = ?");
			sql.setString(1, titulo_revista);
		} catch (SQLException e) {
			logger.error("falha!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
	}

}
