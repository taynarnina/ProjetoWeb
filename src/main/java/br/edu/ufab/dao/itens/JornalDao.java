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
import br.edu.ufab.modelo.itens.Jornal;
/**
 * Classe que faz a relação entre Jornal e a tabela jornais do banco de dados.
 * Essa classe herda os métodos de ItemDaoIF.
 * 
 * @author Taynar Sousa e Murilo Gustavo
 * */
public class JornalDao implements ItemDaoIF{

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(JornalDao.class);
	
	/**
	 * Método que abre a conexão com o banco de dados
	 * @param connection
	 * */
	
	public JornalDao(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Método que recebe um objeto e adiciona seus dados no banco de dados.
	 * 
	 * @param o
	 * */
	
	@Override
	public boolean adiciona(Object o) throws SQLException {
		String sql = "INSERT INTO jornais(titulo,editora,data,edicao,numero_paginas)"
				+ " VALUES(?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ((Acervo) o).getTitulo());
			stmt.setString(2, ((Impressos) o).getEditora());
			stmt.setString(3, ((Jornal) o).getData());
			stmt.setString(4, ((Impressos) o).getEdicao());
			stmt.setInt(5, ((Impressos) o).getNumero_paginas());
			
			stmt.execute();
			logger.info("Jornal inserido com sucesso!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo jornal",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada!");
		}
		return false;
	}
	/**
	 * Método que lista todos os jornais cadastrados no banco de dados.
	 * 
	 * @param o
	 * */
	@Override
	public List<Object> lista(){
		logger.info("gerando lista...");
		return null;
		
	}
	
	/**
	 * Método que recebe um id e retorna um objeto do tipo Jornal 
	 * (retorna dados de Jornal).
	 * 
	 * @param id
	 * */
	
	@Override
	public Jornal pesquisa(int id) throws SQLException {
		String sql = "select * from jornais where idjornal = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Jornal jornal = new Jornal();
			
			while(rs.next()){
				
				//criando o objeto Jornal
				jornal.setId(rs.getInt("idjornal"));
				jornal.setTitulo((rs.getString("titulo")));
				jornal.setEditora(rs.getString("editora"));
				jornal.setData(rs.getString("data"));
				jornal.setEdicao(rs.getString("edicao"));
				jornal.setNumero_paginas(rs.getInt("numero_paginas"));
			}
			
			rs.close();
			logger.info("Pesquisa concluída com sucesso!");
			return	jornal;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar jornal por id",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada!");
		}
		return null;
	}
	
	/**
	 * Método que recebe um objeto e altera seus dados no banco de dados.
	 * 
	 * @param o
	 * */
	
	@Override
	public boolean altera(Object o) throws SQLException {
		String sql = "update jornais set titulo=?, editora=?, data=?,"
				+ "edicao=?, numero_paginas=? where idjornal=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ((Acervo) o).getTitulo());
			stmt.setString(2, ((Impressos) o).getEditora());
			stmt.setString(3, ((Jornal) o).getData());
			stmt.setString(4, ((Impressos) o).getEdicao());
			stmt.setInt(5, ((Impressos) o).getNumero_paginas());
			stmt.setInt(6, ((Acervo) o).getId());
			stmt.execute();
			logger.info("Alterações em jornal concluídas!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar jornal",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("conexão encerrada");
		}
		return false;
	}
	
	/**
	 * Método que recebe um objeto e faz a remoção dos seus dados 
	 * no banco de dados.
	 * 
	 * @param o
	 * */
	
	@Override
	public boolean remove(Object o) throws SQLException {
		String sql = "delete from jornais where idjornal=?";
		PreparedStatement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, ((Acervo) o).getId());
			stmt.execute();
			logger.info("Exclusão de jornal concluída!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir jornal",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("conexão encerrada");
		}
		return false;
	}
}
