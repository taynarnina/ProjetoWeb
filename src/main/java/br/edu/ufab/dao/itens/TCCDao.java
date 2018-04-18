package br.edu.ufab.dao.itens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.itens.TCC;
/**
 * Classe respons�vel por fazer a rela��o dos dados de TCC com o banco de dados
 * @author Murilo Gustavo e Taynar Sousa
 * */
public class TCCDao {

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(TCCDao.class);
	/**
	 * M�todo que inicializa a conex�o com o banco de dados.
	 * @param connection
	 * */
	public TCCDao(Connection connection) {
		this.connection = connection;
	}
	/**
	 * M�todo que recebe um objeto do tipo TCC e realiza um insert no banco de dados.
	 * @param tcc
	 * */
	public boolean adiciona(TCC tcc) throws SQLException {
		String sql = "INSERT INTO tcc(titulo,tipo,autores,orientador,ano_defesa, local)"
				+ " VALUES(?,?,?,?,?.?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, tcc.getTitulo());
			stmt.setString(2, tcc.getTipo());
			stmt.setString(3, tcc.getAutores());
			stmt.setString(4, tcc.getOrientador());
			stmt.setInt(5, tcc.getAno_defesa());
			stmt.setString(6, tcc.getLocal());
			
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo tcc",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return false;
	}
	/**
	 * M�todo que vai listar todos os TCC's cadastrados no banco de dados.
	 * 
	 * */
	public List<TCC> lista(){
		return null;
		
	}
	/**
	 * M�todo que a a partir do id de TCC faz a pesquisa no banco de dados.
	 * @param id
	 * */
	public TCC pesquisa(int id) throws SQLException {
		String sql = "select * from tcc where idtcc = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			TCC tcc = new TCC();
			
			while(rs.next()){
				
				//criando o objeto TCC
				tcc.setId(rs.getInt("idtcc"));
				tcc.setTitulo((rs.getString("titulo")));
				tcc.setTipo(rs.getString("tipo"));
				tcc.setAutores(rs.getString("autores"));
				tcc.setOrientador(rs.getString("orientador"));
				tcc.setAno_defesa(rs.getInt("ano_defesa"));
				tcc.setLocal(rs.getString("local"));
			}
			
			rs.close();
			
			return	tcc;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar tcc por id",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return null;
	}
	/**
	 * M�todo que realiza a altera��o dos dados de um tcc .
	 * @param tcc
	 * */
	public boolean altera(TCC tcc) throws SQLException {
		String sql = "update tcc set titulo=?, tipo=?, autores=?,"
				+ "orientador=?, ano_defesa=?, local=? where idtcc=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, tcc.getTitulo());
			stmt.setString(2, tcc.getTipo());
			stmt.setString(3, tcc.getAutores());
			stmt.setString(4, tcc.getOrientador());
			stmt.setInt(5, tcc.getAno_defesa());
			stmt.setString(6, tcc.getLocal());
			stmt.setInt(7, tcc.getId());
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar tcc",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
	/**
	 * M�todo que recebe um objeto do tipo TCC como par�metro e realiza a 
	 * remo��o do tcc no banco de dados.
	 * @param tcc
	 * */
	public boolean remove(TCC tcc) throws SQLException {
		String sql = "delete from tcc where idtcc=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, tcc.getId());
			stmt.execute();
			
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir tcc",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
}
