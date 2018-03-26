package DAO;


import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import biblio.Anais;
import biblio.Livro;

public  class AnaisDao implements Acervo<Anais> {
	
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(LivroDao.class);
	
	
	public AnaisDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}
	
	public void criar(Anais a) throws SQLException {
		
		PreparedStatement sql =null;
		try {
		 sql = conexion.prepareStatement("INSERT INTO anais(titulo,tipo,autores,nome_congresso,ano_publiclocal) VALUES(?,?,?,?,?,?)");
		 sql.setString(1,a.getTitulo());		
		 sql.setString(2,a.getTipo());
		 sql.setString(3,a.getAutores());
		 sql.setString(4,a.getNome_congresso());
		 sql.setInt(5,a.getAnopublic());
		 sql.setString(6,a.getLocal());
		 sql.execute();
		}catch(SQLException e){

			logger.error("erro na inserção dos dados!");
			throw new SQLException(e.getMessage());
			
		}
		sql.close();
		conexion.close();
	}

	public void editar(String titulo_negocio,String troca_titulo)throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("UPDATE anais SET titulo = ?  WHERE titulo = ?");
			sql.setString(1, troca_titulo);
			sql.setString(2, titulo_negocio);
			sql.execute();
		} catch (SQLException e) {
			logger.error("falha ao editar!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
	}
		

	public void pesquisar(String titulo_negocio) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("SELECT * FROM anais WHERE titulo = ?");
			sql.setString(1, titulo_negocio);
			sql.execute();
		} catch (SQLException e) {
			logger.error("falha na pesquisa!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
	}


	public void excluir(String titulo_negocio) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("DELETE FROM anais WHERE titulo = ?");
			sql.setString(1, titulo_negocio);
			sql.execute();
		} catch (SQLException e) {
			logger.error("falha!");
			e.printStackTrace();
		}
		sql.close();
		conexion.close();
		
	}

}