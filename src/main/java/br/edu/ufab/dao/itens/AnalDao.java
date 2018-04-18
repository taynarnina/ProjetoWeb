package br.edu.ufab.dao.itens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.itens.Anal;
/**
 * Classe responsável por fazer o relacionamento dos dados de Alunos
 * com o banco de dados
 * 
 * @author Murilo Gustavo e Taynar Sousa
 * */
public class AnalDao {
	
	private Connection connection;
	private static final Logger logger = LogManager.getLogger(AnalDao.class);
	/**
	 * Método que inicializa a conexão com o banco de dados.
	 * @param connection
	 * */
	public AnalDao(Connection connection) {
		this.connection = connection;
	}
	/**
	 * Método que recebe um objeto do tipo Anal e a partir dele adiciona os dados no banco.
	 * @param anal
	 * */
	public boolean adiciona(Anal anal) throws SQLException {
		String sql = "INSERT INTO anais(titulo,tipo,autores,nome_congresso,ano_publicacao, local)"
				+ " VALUES(?,?,?,?,?.?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, anal.getTitulo());
			stmt.setString(2, anal.getTipo());
			stmt.setString(3, anal.getAutores());
			stmt.setString(4, anal.getNome_congresso());
			stmt.setInt(5, anal.getAno_publicacao());
			stmt.setString(6, anal.getLocal());
			
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo anal",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return false;
	}
	
	public List<Anal> lista(){
		return null;
		
	}
	/**
	 * Método que recebe um id e a partir dele realiza a pesquisa de determinado.
	 * @param id
	 * */
	public Anal pesquisa(int id) throws SQLException {
		String sql = "select * from anais where idanal = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Anal anal = new Anal();
			
			while(rs.next()){
				
				//criando o objeto Anal
				anal.setId(rs.getInt("idanal"));
				anal.setTitulo((rs.getString("titulo")));
				anal.setTipo(rs.getString("tipo"));
				anal.setAutores(rs.getString("autores"));
				anal.setNome_congresso(rs.getString("nome_congresso"));
				anal.setAno_publicacao(rs.getInt("ano_publicacao"));
				anal.setLocal(rs.getString("local"));
			}
			
			rs.close();
			
			return	anal;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar anal por id",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return null;
	}
	/**
	 * Método que recebe um objeto do tipo Anal e faz a alteração no banco de dados.
	 * @param anal
	 * */
	public boolean altera(Anal anal) throws SQLException {
		String sql = "update anais set titulo=?, tipo=?, autores=?,"
				+ "nome_congresso=?, ano_publicacao=?, local=? where idanal=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, anal.getTitulo());
			stmt.setString(2, anal.getTipo());
			stmt.setString(3, anal.getAutores());
			stmt.setString(4, anal.getNome_congresso());
			stmt.setInt(5, anal.getAno_publicacao());
			stmt.setString(6, anal.getLocal());
			stmt.setInt(7, anal.getId());
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar anal",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
	/**
	 * Método que realiza a remoção de um anal no banco de dados .
	 * @param anal
	 * */
	public boolean remove(Anal anal) throws SQLException {
		String sql = "delete from anais where idanal=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, anal.getId());
			stmt.execute();
			
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir anal",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
}
