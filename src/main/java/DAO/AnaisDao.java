package DAO;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import biblio.Anais;

public  class AnaisDao implements Acervo<Anais> {
	
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(AnaisDao.class);
	
	
	public AnaisDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}
	
	@SuppressWarnings("finally")
	public boolean criar(Anais a) throws SQLException {
		
		PreparedStatement sql =null;
		try {
			 sql = conexion.prepareStatement("INSERT INTO anais(titulo,tipo,autores,nome_congresso,ano_public,local) VALUES(?,?,?,?,?,?)");
			 sql.setString(1,a.getTitulo());		
			 sql.setString(2,a.getTipo());
			 sql.setString(3,a.getAutores());
			 sql.setString(4,a.getNome_congresso());
			 sql.setInt(5,a.getAnopublic());
			 sql.setString(6,a.getLocal());
			 sql.execute();
			 
			 sql.close();
			 conexion.close();
			 
			 return true;
		}catch(SQLException e){

			logger.error(e.getMessage());
			sql.close();
			conexion.close();
			return false;
		}
			
		
	}

	public boolean editar(String titulo_negocio,String troca_titulo)throws SQLException {
		PreparedStatement sql =null;
		AnaisDao ad = new AnaisDao();
		try {
			if(ad.pesquisar(titulo_negocio)==true) {
			sql = conexion.prepareStatement("UPDATE anais SET titulo = ?  WHERE titulo = ?");
			sql.setString(1, troca_titulo);
			sql.setString(2, titulo_negocio);
			sql.execute();
			return true;
			}
		} catch (SQLException e) {
			logger.error("falha ao editar!");
			
		}
		sql.close();
		conexion.close();
		
		return false;
		
	}
		

	public boolean pesquisar(String titulo_negocio) throws SQLException {
		PreparedStatement sql =null;
		
		try {
			sql = conexion.prepareStatement("SELECT * FROM anais WHERE titulo = ?");
			sql.setString(1, titulo_negocio);
			ResultSet result =sql.executeQuery();
			

			
			return result.next();
		} catch (SQLException e) {
			logger.error("falha na pesquisa!");
			return false;
			
		}finally {
			sql.close();
			conexion.close();
		}
		
		
		
	}


	public boolean excluir(String titulo_negocio) throws SQLException {
		AnaisDao ad = new AnaisDao();
		PreparedStatement sql =null;
		try {
			if(ad.pesquisar(titulo_negocio) == true) {
			sql = conexion.prepareStatement("DELETE FROM anais WHERE titulo = ?");
			sql.setString(1, titulo_negocio);
			sql.executeUpdate();
			
			boolean result = ad.pesquisar(titulo_negocio);
			if(result == false) {
				return true;
			}
			}
			
		} catch (SQLException e) {
			logger.error("falha!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
		return false;
		
	}

}