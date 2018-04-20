package br.edu.ufab.dao.itens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.itens.Livro;

public class LivroDao {

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(LivroDao.class);
	
	public LivroDao(Connection connection) {
		this.connection = connection;
		logger.info("iniciando conexão...");
	}
	
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
			logger.info("Livro adicionado com sucesso!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo livro",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("Conexão encerrada");
		}
		return false;
	}
	
	public List<Livro> lista(){
		logger.info("listando...");
		return null;
		
	}
	
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
			logger.info("pesquisa concluída com sucesso!!");
			return	livro;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar livro por id",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("Conexão encerrada");
		}
		return null;
	}
	
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
			logger.info("dados alterados com sucesso!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar livro",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("Conexão encerrada");
		}
		return false;
	}
	
	public boolean remove(Livro livro) throws SQLException {
		String sql = "delete from livros where idlivro=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, livro.getId());
			stmt.execute();
			logger.info("Dados removidos!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir livro",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("Conexão encerrada");
		}
		return false;
	}
}