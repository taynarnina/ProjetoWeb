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
import br.edu.ufab.modelo.itens.MidiaEletronica;
/**
 * Classe que faz a rela��o entre MidiasEletronicas e a tabela 
 * midias do banco de dados.
 * Essa classe herda os m�todos de ItemIF.
 * 
 * @author Taynar Sousa e Murilo Gustavo
 * */
public class MidiaEletronicaDao implements ItemDaoIF{

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(MidiaEletronicaDao.class);
	
	/**
	 * M�todo que vai abrir a conex�o com o banco de dados
	 * @param connection
	 * */
	
	public MidiaEletronicaDao(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * M�todo que vai receber um tipo de item do acervo (que � a m�dia)
	 * e vai cadastrar no banco de dados. 
	 * Ela vai receber um objeto e ira tratar o memso dentro do m�todo.
	 * 
	 * @param  o
	 * */
	
	@Override
	public boolean adiciona(Object o) throws SQLException {
		String sql = "INSERT INTO midias(titulo,tipo,data_gravacao) VALUES(?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ((Acervo) o).getTitulo());
			stmt.setString(2, ((MidiaEletronica) o).getTipo());
			stmt.setString(3, ((MidiaEletronica) o).getData_gravacao());
			stmt.execute();
			logger.info("Midia inserida com sucesso!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar nova midia",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conex�o encerrada!");
		}
		return false;
	}
	
	/**
	 * M�todo que vai listar todas as m�dias cadastradas no banco de dados.
	 * */
	
	@Override
	public List<Object> lista(){
		return null;
		
	}
	
	/**
	 * M�todo que vai receber um id de midias e ir� retornar seus dados no
	 * banco de dados. 
	 * 
	 * @param  id
	 * */
	
	@Override
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
			logger.info("Pesquisa conclu�da com sucesso!");
			return	midia;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar midia por id",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conex�o encerrada!");
		}
		return null;
	}
	
	/**
	 * M�todo que vai receber um tipo de item do acervo (que � a m�dia) e vai alterar
	 * os seus dados no banco de dados.
	 *  Ela vai receber um objeto e ira tratar o memso dentro do m�todo.
	 * 
	 * @param  o
	 * */
	
	@Override
	public boolean altera(Object o) throws SQLException {
		String sql = "update midias set titulo=?, tipo=?, data_gravacao=? where idmidia=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ((Acervo) o).getTitulo());
			stmt.setString(2, ((MidiaEletronica) o).getTipo());
			stmt.setString(3, ((MidiaEletronica) o).getData_gravacao());
			stmt.setInt(4, ((Acervo) o).getId());
			stmt.execute();
			logger.info("Altera��es em m�dia conclu�das!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar midia",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conex�o encerrada!");
		}
		return false;
	}
	
	/**
	 * M�todo que vai receber um tipo de item do acervo que � a m�dia e ir� remover
	 * do banco de dados.
	 * 
	 * @param  o
	 * */
	
	@Override
	public boolean remove(Object o) throws SQLException {
		String sql = "delete from midias where idmidia=?";
		PreparedStatement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, ((Acervo) o).getId());
			stmt.execute();
			logger.info("Exclus�o de m�dia conclu�da!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir midia",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("conex�o encerrada!");
		}
		return false;
	}
}
