package br.edu.ufab.dao.itens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.itens.Livro;
/**
 * Classe responsável por fazer a relação dos dados de Livro com o banco de dados
 * @author Murilo Gustavo e Taynar Sousa
 * */
public class LivroDao {

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(LivroDao.class);
	/**
	 * Método que inicializa a conexão com o banco de dados.
	 * @param connection
	 * */
	public LivroDao(Connection connection) {
		this.connection = connection;
	}
	/**
	 * Método que recebe um objeto do tipo Livro e realiza um insert no banco de dados.
	 * @param livro
	 * */
	public boolean adiciona(Livro livro) throws SQLException {
		String sql = "INSERT INTO livros(isbn,titulo,autores,editora,ano_publicacao,edicao,numero_paginas,"
				+"area,tema) VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, livro.getISBN());
			stmt.setString(2, livro.getTitulo());
			stmt.setString(3, livro.getAutores());
			stmt.setString(4, livro.getEditora());
			stmt.setInt(5, livro.getAno_publicacao());
			stmt.setString(6, livro.getEdicao());
			stmt.setInt(7, livro.getNumero_paginas());
			stmt.setString(8, livro.getArea());
			stmt.setString(9, livro.getTema());
			
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo livro",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return false;
	}
	/**
	 * Método que vai listar todos os livros cadastrados no banco de dados.
	 * 
	 * */
	public List<Livro> lista(){
		return null;
		
	}
	/**
	 * Método que realiza a pesquisa dos dados de um livro a partir do seu id.
	 * @param id
	 * */
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
			
			return	livro;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar livro por id",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return null;
	}
	/**
	 * Método que recebe um objeto do tipo Livro  e faz a alteração no banco de dados.
	 * @param livro
	 * */
	public boolean altera(Livro livro) throws SQLException {
		String sql = "update livros set isbn=?, titulo=?, autores=?, editora=?, ano_publicacao=?,"
				+ "edicao=?, numero_paginas=?, area=?, tema=? where idlivro=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, livro.getISBN());
			stmt.setString(2, livro.getTitulo());
			stmt.setString(3, livro.getAutores());
			stmt.setString(4, livro.getEditora());
			stmt.setInt(5, livro.getAno_publicacao());
			stmt.setString(6, livro.getEdicao());
			stmt.setInt(7, livro.getNumero_paginas());
			stmt.setString(8, livro.getArea());
			stmt.setString(9, livro.getTema());
			stmt.setInt(10, livro.getId());
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar livro",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
	/**
	 * Método que recebe um livro como parâmetro e realiza a remoção do livro no banco de dados.
	 * @param livro
	 * */
	public boolean remove(Livro livro) throws SQLException {
		String sql = "delete from livros where idlivro=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, livro.getId());
			stmt.execute();
			
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir livro",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
}
