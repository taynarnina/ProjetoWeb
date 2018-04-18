package br.edu.ufab.dao.itens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.itens.Revista;
/**
 * Classe respons�vel por fazer a rela��o dos dados de Revista com o banco de dados
 * @author Murilo Gustavo e Taynar Sousa
 * */
public class RevistaDao {
	
	private Connection connection;
	private static final Logger logger = LogManager.getLogger(RevistaDao.class);
	/**
	 * M�todo que inicializa a conex�o com o banco de dados.
	 * @param connection
	 * */
	public RevistaDao(Connection connection) {
		this.connection = connection;
	}
	/**
	 * M�todo que recebe os dados de revista e realiza um insert no banco de dados.
	 * @param revista
	 * */
	public boolean adiciona(Revista revista) throws SQLException {
		String sql = "INSERT INTO revistas(titulo,editora,data_publicacao,edicao,numero_paginas)"
				+ " VALUES(?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, revista.getTitulo());
			stmt.setString(2, revista.getEditora());
			stmt.setString(3, revista.getData_publicacao());
			stmt.setString(4, revista.getEdicao());
			stmt.setInt(5, revista.getNumero_paginas());
			
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar nova revista",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return false;
	}
	/**
	 * M�todo que vai listar todas as revistas cadastradas no banco de dados.
	 * 
	 * */
	public List<Revista> lista(){
		return null;
		
	}
	/**
	 * M�todo que a apartir do id da revista faz a pesquisa no banco de dados.
	 * @param id
	 * */
	public Revista pesquisa(int id) throws SQLException {
		String sql = "select * from revistas where idrevista = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Revista revista = new Revista();
			
			while(rs.next()){
				
				//criando o objeto Revista
				revista.setId(rs.getInt("idrevista"));
				revista.setTitulo((rs.getString("titulo")));
				revista.setEditora(rs.getString("editora"));
				revista.setData_publicacao(rs.getString("data_publicacao"));
				revista.setEdicao(rs.getString("edicao"));
				revista.setNumero_paginas(rs.getInt("numero_paginas"));
			}
			
			rs.close();
			
			return	revista;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar revista por id",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return null;
	}
	/**
	 * M�todo que faz a altera��o no banco de dados a partir do recebimento de um objeto Revista.
	 * @param revista
	 * */
	public boolean altera(Revista revista) throws SQLException {
		String sql = "update revistas set titulo=?, editora=?, data_publicacao=?,"
				+ "edicao=?, numero_paginas=? where idrevista=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, revista.getTitulo());
			stmt.setString(2, revista.getEditora());
			stmt.setString(3, revista.getData_publicacao());
			stmt.setString(4, revista.getEdicao());
			stmt.setInt(5, revista.getNumero_paginas());
			stmt.setInt(6, revista.getId());
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar revista",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
	/**
	 * M�todo que recebe uma revista como par�metro e realiza a remo��o dos seus dados no banco de dados.
	 * @param revista
	 * */
	public boolean remove(Revista revista) throws SQLException {
		String sql = "delete from revistas where idrevista=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, revista.getId());
			stmt.execute();
			
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir revista",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
}
