package DAO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import biblio.Livro;

public  class LivroDao implements Acervo<Livro> {
	
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(LivroDao.class);
	
	
	public LivroDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}
	
	public boolean criar(Livro l) throws SQLException {
		
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
			 
			 sql.close();
			 conexion.close();
			
			 return true;
		}catch(SQLException e){

			logger.error("erro na inserção dos dados"+e.getMessage());
			
		}
		sql.close();
		conexion.close();
		
		return false;
		
	}

	public boolean editar(String titulo_livro,String troca_titulo)throws SQLException {
		PreparedStatement sql =null;
		LivroDao ld = new LivroDao();
		try {
			if(ld.pesquisar(titulo_livro)==true) {
			sql = conexion.prepareStatement("UPDATE livro SET titulo = ?  WHERE titulo = ?");
			sql.setString(1, troca_titulo);
			sql.setString(2, titulo_livro);
			sql.execute();
			return true;
			}
		} catch (SQLException e) {
			logger.error("falha ao editar!"+e.getMessage());
			
		}
		sql.close();
		conexion.close();
		
		return false;
		
	}
		

	public boolean pesquisar(String titulo_livro) throws SQLException {
		PreparedStatement sql =null;
		
		try {
			sql = conexion.prepareStatement("SELECT * FROM livro WHERE titulo = ?");
			sql.setString(1, titulo_livro);
			ResultSet result =sql.executeQuery();
			

			
			return result.next();
		} catch (SQLException e) {
			logger.error("falha na pesquisa!"+ e.getMessage());
			
		}finally {
			sql.close();
			conexion.close();
		}
		
		
		return false;
	}


	public boolean excluir(String titulo_livro) throws SQLException {
		LivroDao ld = new LivroDao();
		PreparedStatement sql =null;
		try {
			if(ld.pesquisar(titulo_livro) == true) {
			sql = conexion.prepareStatement("DELETE FROM livro WHERE titulo = ?");
			sql.setString(1, titulo_livro);
			sql.executeUpdate();
			
			boolean result = ld.pesquisar(titulo_livro);
			if(result == false) {
				return true;
			}
			}
			
		} catch (SQLException e) {
			logger.error("falha!"+e.getMessage());
			
		}
		sql.close();
		conexion.close();
		
		return false;
		
	}

}
