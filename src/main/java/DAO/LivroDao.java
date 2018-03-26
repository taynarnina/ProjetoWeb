package DAO;


import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import biblio.Livro;

public  class LivroDao implements Acervo<Livro> {
	
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(LivroDao.class);
	
	
	public LivroDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}
	
	public void criar(Livro l) throws SQLException {
		
		PreparedStatement sql =null;
		try {
		 sql = conexion.prepareStatement("INSERT INTO livro(titulo,autor,isbn,editora,ano_public,numpaginas,area_conhecimento,tema) VALUES(?,?,?,?,?,?,?,?)");
		 sql.setString(1,l.getTitulo());		
		 sql.setString(2,l.getAutor());
		 sql.setLong(3,l.getIsbn());
		 sql.setString(4,l.getEditora());
		 sql.setInt(5,l.getAnopublic());
		 sql.setInt(6,l.getNumpaginas());
		 sql.setString(7,l.getArea_conhecimento());
		 sql.setString(8,l.getTema());
		 sql.execute();
		}catch(SQLException e){

			logger.error("erro na inserção dos dados!");
			throw new SQLException(e.getMessage());
			
		}
		sql.close();
		conexion.close();
		
	}

	public void editar(String titulo_livro,String troca_titulo)throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("UPDATE livro SET titulo = ?  WHERE titulo = ?");
			sql.setString(1, troca_titulo);
			sql.setString(2, titulo_livro);
			sql.execute();
		} catch (SQLException e) {
			logger.error("falha ao editar!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
	}
		

	public void pesquisar(String titulo_livro) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("SELECT * FROM livro WHERE titulo = ?");
			sql.setString(1, titulo_livro);
			sql.execute();
		} catch (SQLException e) {
			logger.error("falha na pesquisa!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
	}


	public void excluir(String titulo_livro) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("DELETE FROM livro WHERE titulo = ?");
			sql.setString(1, titulo_livro);
			sql.execute();
		} catch (SQLException e) {
			logger.error("falha!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
	}

}
