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
import br.edu.ufab.modelo.itens.Livro;
/**
 * Classe que faz a relação entre Livro e a tabela livros do banco de dados.
 * Essa classe herda os métodos de ItemIF.
 * 
 * @author Taynar Sousa e Murilo Gustavo
 * */
public class LivroDao implements ItemDaoIF{

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(LivroDao.class);
	
	/**
	 * Método que vai abrir a conexão com o banco de dados
	 * @param connection
	 * */
	public LivroDao(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Método que vai receber um objeto e vai adicionar seus dados no
	 * banco de dados.
	 *  Ela vai receber um objeto e ira tratar o memso dentro do método.
	 * 
	 * @param  o
	 * */
	
	@Override
	public boolean adiciona(Object o) throws SQLException {
		String sql = "INSERT INTO livros(isbn,titulo,autores,editora,ano_publicacao,edicao,numero_paginas,"
				+"area,tema) VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ((Livro) o).getISBN());
			stmt.setString(2, ((Acervo) o).getTitulo());
			stmt.setString(3, ((Livro) o).getAutores());
			stmt.setString(4, ((Impressos) o).getEditora());
			stmt.setInt(5, ((Livro) o).getAno_publicacao());
			stmt.setString(6, ((Impressos) o).getEdicao());
			stmt.setInt(7, ((Impressos) o).getNumero_paginas());
			stmt.setString(8, ((Livro) o).getArea());
			stmt.setString(9, ((Livro) o).getTema());
			
			stmt.execute();
			logger.info("Dados de livro inseridos com sucesso!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo livro",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada!");
		}
		return false;
	}
	
	/**
	 * Método que vai listar todos os livros cadastrados no banco de dados.
	 * */
	
	@Override
	public List<Object> lista(){
		logger.info("gerando lista...");
		return null;
		
	}
	
	/**
	 * Método que vai receber o id de determinado livro e retorna
	 *  os dados desse livro.
	 * 
	 * @param  id
	 * */
	
	@Override
	public Livro pesquisa(int id) throws SQLException {
		String sql = "select * from livros where idlivro = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Livro livro = new Livro();
			
			while(rs.next()){
				
				//criando o objeto Livro
				livro.setId(rs.getInt("idlivro"));
				livro.setISBN(rs.getString("isbn"));
				livro.setTitulo((rs.getString("titulo")));
				livro.setAutores(rs.getString("autores"));
				livro.setEditora(rs.getString("editora"));
				livro.setAno_publicacao(rs.getInt("ano_publicacao"));
				livro.setEdicao(rs.getString("edicao"));
				livro.setNumero_paginas(rs.getInt("numero_paginas"));
				livro.setArea(rs.getString("area"));
				livro.setTema(rs.getString("tema"));
			}
			
			rs.close();
			logger.info("Pesquisa concluída com sucesso!");
			return	livro;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar livro por id",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada!");
		}
		return null;
	}
	/**
	 * Método que vai receber um objeto e vai realizar a alteração de seus dados.
	 * Ela vai receber um objeto e ira tratar o memso dentro do método.
	 * 
	 * @param  o
	 * */
	@Override
	public boolean altera(Object o) throws SQLException {
		String sql = "update livros set isbn=?, titulo=?, autores=?, editora=?, ano_publicacao=?,"
				+ "edicao=?, numero_paginas=?, area=?, tema=? where idlivro=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ((Livro) o).getISBN());
			stmt.setString(2, ((Acervo) o).getTitulo());
			stmt.setString(3, ((Livro) o).getAutores());
			stmt.setString(4, ((Impressos) o).getEditora());
			stmt.setInt(5, ((Livro) o).getAno_publicacao());
			stmt.setString(6, ((Impressos) o).getEdicao());
			stmt.setInt(7, ((Impressos) o).getNumero_paginas());
			stmt.setString(8, ((Livro) o).getArea());
			stmt.setString(9, ((Livro) o).getTema());
			stmt.setInt(10, ((Acervo) o).getId());
			stmt.execute();
			logger.info("Alterações concluídas!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar livro",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("conexão encerrada");
		}
		return false;
	}
	
	/**
	 * Método que vai receber um objeto e removê-lo do banco de dados.
	 * Ela vai receber um objeto e ira tratar o memso dentro do método.
	 * 
	 * @param  o
	 * */
	
	@Override
	public boolean remove(Object o) throws SQLException {
		String sql = "delete from livros where idlivro=?";
		PreparedStatement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, ((Acervo) o).getId());
			stmt.execute();
			logger.info("Exclusão do livro concluída!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir livro",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("conexão encerrada");
		}
		return false;
	}
}
