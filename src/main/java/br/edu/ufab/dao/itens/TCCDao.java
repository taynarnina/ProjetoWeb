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
import br.edu.ufab.modelo.itens.TCC;
import br.edu.ufab.modelo.itens.TrabalhoAcademico;
/**
 * Classe que faz a relação entre TCC e a tabela tcc do banco de dados.
 * Essa classe herda os métodos de ItemDaoIF.
 * 
 * @author Taynar Sousa e Murilo Gustavo
 * */
public class TCCDao implements ItemDaoIF{

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(TCCDao.class);
	
	/**
	 * Método que vai abrir a conexão com o banco de dados
	 * @param connection
	 * */
	
	public TCCDao(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Método que vai receber um tipo de item do acervo que é o tcc e vai cadastrar no
	 * banco de dados.
	 * 
	 * @param  o
	 * */
	
	@Override
	public boolean adiciona(Object o) throws SQLException {
		String sql = "INSERT INTO tcc(titulo,tipo,autores,orientador,ano_defesa, local)"
				+ " VALUES(?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ((Acervo) o).getTitulo());
			stmt.setString(2, ((TrabalhoAcademico) o).getTipo());
			stmt.setString(3, ((TrabalhoAcademico) o).getAutores());
			stmt.setString(4, ((TCC) o).getOrientador());
			stmt.setInt(5, ((TCC) o).getAno_defesa());
			stmt.setString(6, ((TrabalhoAcademico) o).getLocal());
			logger.info("Tcc inserido com sucesso!!");
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo tcc",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada");
		}
		return false;
	}
	
	/**
	 * Método que vai listar todos os tcc's cadastrados
	 * 
	 * */
	
	@Override
	public List<Object> lista(){
		logger.info("gerando lista...");
		return null;
		
	}
	
	/**
	 * Método que vai receber o id de um tcc e irá retornar os seus dados.	 
	 * 
	 * @param  id
	 * */
	
	@Override
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
			logger.info("Pesquisa concluída com sucesso!");
			return	tcc;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar tcc por id",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada");
		}
		return null;
	}
	
	/**
	 * Método que vai receber um tipo de item do acervo que é o tcc e vai realizar a alteração de 
	 * seus dados no banco de dados. 
	 * 
	 * @param  o
	 * */
	
	@Override
	public boolean altera(Object o) throws SQLException {
		String sql = "update tcc set titulo=?, tipo=?, autores=?,"
				+ "orientador=?, ano_defesa=?, local=? where idtcc=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ((Acervo) o).getTitulo());
			stmt.setString(2, ((TrabalhoAcademico) o).getTipo());
			stmt.setString(3, ((TrabalhoAcademico) o).getAutores());
			stmt.setString(4, ((TCC) o).getOrientador());
			stmt.setInt(5, ((TCC) o).getAno_defesa());
			stmt.setString(6, ((TrabalhoAcademico) o).getLocal());
			stmt.setInt(7, ((Acervo) o).getId());
			stmt.execute();
			logger.info("Alterações concluídas com sucesso!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar tcc",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("conexão encerrada");
		}
		return false;
	}
	
	/**
	 * Método que vai receber um tipo de item do acervo que é o tcc e 
	 * vai removê-lo do  banco de dados.
	 * 
	 * @param  o
	 * */
	
	@Override
	public boolean remove(Object o) throws SQLException {
		String sql = "delete from tcc where idtcc=?";
		PreparedStatement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, ((Acervo) o).getId());
			stmt.execute();
			logger.info("Remoção de tcc concluído!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir tcc",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("Conexão encerrada!");
		}
		return false;
	}
}
