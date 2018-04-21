package br.edu.ufab.dao.itens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.jdbc.ConnectionFactory;
import br.edu.ufab.modelo.itens.Acervo;
import br.edu.ufab.modelo.itens.Impressos;
import br.edu.ufab.modelo.itens.Revista;
/**
 * Classe que faz a rela��o entre Revista e a tabela revistas do banco de dados.
 * Essa classe herda os m�todos de ItemDaoIF.
 * 
 * @author Taynar Sousa e Murilo Gustavo
 * */

public class RevistaDao implements ItemDaoIF{
	
	private Connection connection;
	private static final Logger logger = LogManager.getLogger(RevistaDao.class);
	/**
	 * M�todo que vai abrir a conex�o com o banco de dados
	 * @param connection
	 * */
	public RevistaDao(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * M�todo que vai receber um tipo de item do acervo que � a revista
	 * e vai adicionar seus dados no banco de dados. 
	 * 
	 * @param  o
	 * */
	
	@Override
	public boolean adiciona(Object o) throws SQLException {
		String sql = "INSERT INTO revistas(titulo,editora,data_publicacao,edicao,numero_paginas)"
				+ " VALUES(?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ((Acervo) o).getTitulo());
			stmt.setString(2, ((Impressos) o).getEditora());
			stmt.setString(3, ((Revista) o).getData_publicacao());
			stmt.setString(4, ((Impressos) o).getEdicao());
			stmt.setInt(5, ((Impressos) o).getNumero_paginas());
			
			stmt.execute();
			logger.info("Revista inserida com sucesso!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar nova revista",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conex�o encerrada!");
		}
		return false;
	}
	
	/**
	 * M�todo que vai listar todos anais cadastrados
	 * 
	 * */
	
	@Override
	public List<Object> lista(){
		logger.info("gerando lista...");
		return null;
		
	}
	
	/**
	 * M�todo que vai receber o id de uma revista e ir� retornar os seus dados.	  
	 * 
	 * @param  id
	 * */
	
	@Override
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
			logger.info("Pesquisa conclu�da com sucesso!");
			return	revista;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar revista por id",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conex�o encerrada!");
		}
		return null;
	}
	
	/**
	 * M�todo que vai receber um tipo de do acervo ue � a revista
	 * e vai realizar a altera��o de seus dados no banco de dados. 
	 * 
	 * @param  o
	 * */
	
	@Override
	public boolean altera(Object o) throws SQLException {
		String sql = "update revistas set titulo=?, editora=?, data_publicacao=?,"
				+ "edicao=?, numero_paginas=? where idrevista=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ((Acervo) o).getTitulo());
			stmt.setString(2, ((Impressos) o).getEditora());
			stmt.setString(3, ((Revista) o).getData_publicacao());
			stmt.setString(4, ((Impressos) o).getEdicao());
			stmt.setInt(5, ((Impressos) o).getNumero_paginas());
			stmt.setInt(6, ((Acervo) o).getId());
			stmt.execute();
			logger.info("Altera��es em revista conclu�das!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar revista",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("conex�o encerrada!");
		}
		return false;
	}
	/**
	 * M�todo que vai receber um tipo de  item do acervo que 
	 * � a revista remov�-lo do  banco de dados.
	 * 
	 * @param  o
	 * */
	@Override
	public boolean remove(Object o) throws SQLException {
		String sql = "delete from revistas where idrevista=?";
		PreparedStatement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, ((Acervo) o).getId());
			stmt.execute();
			logger.info("Exclus�o de revista conclu�da!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir revista",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("conex�o encerrada!");
		}
		return false;
	}
}
