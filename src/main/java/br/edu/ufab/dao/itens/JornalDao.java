package br.edu.ufab.dao.itens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.itens.Jornal;
/**
 * Classe que vai relacionar os dados de Jornal com o banco de dados.
 * @author Murilo Gutavo e Taynar Sousa
 * */
public class JornalDao {

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(JornalDao.class);
	/**
	 * Método que inicializa a conexão com o banco de dados.
	 * @param connection
	 * */
	public JornalDao(Connection connection) {
		this.connection = connection;
	}
	/**
	 * Método que recebe um objeto do tipo jornal como parâmetro
	 * e adiciona no banco de dados.
	 * @param jornal
	 * */
	public boolean adiciona(Jornal jornal) throws SQLException {
		String sql = "INSERT INTO jornais(titulo,editora,data,edicao,numero_paginas)"
				+ " VALUES(?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, jornal.getTitulo());
			stmt.setString(2, jornal.getEditora());
			stmt.setString(3, jornal.getData());
			stmt.setString(4, jornal.getEdicao());
			stmt.setInt(5, jornal.getNumero_paginas());
			
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo jornal",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return false;
	}
	
	public List<Jornal> lista(){
		return null;
		
	}
	/**
	 * Método que recebe um id do jornal e realiza a pesquisa do jornal a partir dele.
	 * @param id
	 * */
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
			
			return	jornal;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar jornal por id",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return null;
	}
	/**
	 * Método que recebe um objeto do tipo jornal e realiza
	 * as alterações de jornal.
	 * @param jornal
	 * */
	public boolean altera(Jornal jornal) throws SQLException {
		String sql = "update jornais set titulo=?, editora=?, data=?,"
				+ "edicao=?, numero_paginas=? where idjornal=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, jornal.getTitulo());
			stmt.setString(2, jornal.getEditora());
			stmt.setString(3, jornal.getData());
			stmt.setString(4, jornal.getEdicao());
			stmt.setInt(5, jornal.getNumero_paginas());
			stmt.setInt(6, jornal.getId());
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar jornal",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
	/**
	 * Método que recebe um objeto do tipo Jornal e realiza a remoção do mesmo.
	 * @param jornal
	 * */
	public boolean remove(Jornal jornal) throws SQLException {
		String sql = "delete from jornais where idjornal=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, jornal.getId());
			stmt.execute();
			
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir jornal",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
}
