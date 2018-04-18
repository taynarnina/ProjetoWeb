package br.edu.ufab.dao.itens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.itens.MidiaEletronica;
/**
 * Classe responsável por fazer a relação dos dados de MidiaEletronica com o banco de dados
 * @author Murilo Gustavo e Taynar Sousa
 * */
public class MidiaEletronicaDao {

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(MidiaEletronicaDao.class);
	/**
	 * Método que inicializa a conexão com o banco de dados.
	 * @param connection
	 * */
	public MidiaEletronicaDao(Connection connection) {
		this.connection = connection;
	}
	/**
	 * Método que recebe um objeto do tipo MidiaEletronica e realiza um insert no banco de dados.
	 * @param midia
	 * */
	public boolean adiciona(MidiaEletronica midia) throws SQLException {
		String sql = "INSERT INTO midias(titulo,tipo,data_gravacao) VALUES(?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, midia.getTitulo());
			stmt.setString(2, midia.getTipo());
			stmt.setString(3, midia.getData_gravacao());
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar nova midia",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return false;
	}
	/**
	 * Método que vai listar todos as mídias cadastradas no banco de dados.
	 * 
	 * */
	public List<MidiaEletronica> lista(){
		return null;
		
	}
	/**
	 * Método que realiza a pesquisa dos dados de uma mídia a partir do seu id.
	 * @param id
	 * */
	public MidiaEletronica pesquisa(int id) throws SQLException {
		String sql = "select * from midias where idmidia = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			MidiaEletronica midia = new MidiaEletronica();
			
			while(rs.next()){
				
				//criando o objeto Midia
				midia.setId(rs.getInt("idmidia"));
				midia.setTitulo((rs.getString("titulo")));
				midia.setTipo(rs.getString("tipo"));
				midia.setData_gravacao(rs.getString("data_gravacao"));
			}
			
			rs.close();
			
			return	midia;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar midia por id",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return null;
	}
	/**
	 * Método que recebe um objeto do tipo MidiaEletronica e faz a alteração no banco de dados.
	 * @param midia
	 * */
	public boolean altera(MidiaEletronica midia) throws SQLException {
		String sql = "update midias set titulo=?, tipo=?, data_gravacao=? where idmidia=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, midia.getTitulo());
			stmt.setString(2, midia.getTipo());
			stmt.setString(3, midia.getData_gravacao());
			stmt.setInt(4, midia.getId());
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar midia",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
	/**
	 * Método que recebe uma midia como parâmetro e realiza a remoção da midia no banco de dados.
	 * @param midia
	 * */
	public boolean remove(MidiaEletronica midia) throws SQLException {
		String sql = "delete from tcc where idmidia=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, midia.getId());
			stmt.execute();
			
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir midia",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
}
