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
import br.edu.ufab.modelo.itens.Anal;
import br.edu.ufab.modelo.itens.TrabalhoAcademico;
/**
 * Classe que faz a relação entre Anal e a tabela anais do banco de dados.
 * Essa classe herda os métodos de ItemDaoIF.
 * 
 * @author Taynar Sousa e Murilo Gustavo
 * */
public class AnalDao implements ItemDaoIF{
	
	private Connection connection;
	private static final Logger logger = LogManager.getLogger(AnalDao.class);
	
	/**
	 * Método que vai abrir a conexão com o banco de dados
	 * @param connection
	 * */
	
	public AnalDao(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Método que vai receber um tipo de item Anal e vai cadastrar no
	 * banco de dados. Ela vai receber um objeto e ira tratar o memso dentro do método.
	 * 
	 * @param  o
	 * */
	
	@Override
	public boolean adiciona(Object o) throws SQLException {
		String sql = "INSERT INTO anais(titulo,tipo,autores,nome_congresso,ano_publicacao,local)"
				+ " VALUES(?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ((Acervo) o).getTitulo());
			stmt.setString(2, ((TrabalhoAcademico) o).getTipo());
			stmt.setString(3, ((TrabalhoAcademico) o).getAutores());
			stmt.setString(4, ((Anal) o).getNome_congresso());
			stmt.setInt(5, ((Anal) o).getAno_publicacao());
			stmt.setString(6, ((TrabalhoAcademico) o).getLocal());
			
			stmt.execute();
			logger.info("Anal inserido com sucesso!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo anal",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada!");
		}
		return false;
	}
	
	/**
	 * Método que vai listar todos anais cadastrados
	 * 
	 * */
	
	@Override
	public List<Object> lista(){
		logger.info("gerando lista...");
		return null;
		
	}
	/**
	 * Método que vai receber o id de um anal e irá retornar os seus dados.	 
	 * 
	 * @param  id
	 * */
	
	
	@Override
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
			logger.info("Pesquisa concluída com sucesso!");
			return	anal;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar anal por id",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada!");
		}
		return null;
	}
	
	/**
	 * Método que vai receber um tipo de item Anal e vai realizar a alteração de 
	 * seus dados no banco de dados. 
	 * Ela vai receber um objeto e ira tratar o memso dentro do método.
	 * 
	 * @param  o
	 * */
	
	
	@Override
	public boolean altera(Object o) throws SQLException {
		String sql = "update anais set titulo=?, tipo=?, autores=?,"
				+ "nome_congresso=?, ano_publicacao=?, local=? where idanal=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ((Acervo) o).getTitulo());
			stmt.setString(2, ((TrabalhoAcademico) o).getTipo());
			stmt.setString(3, ((TrabalhoAcademico) o).getAutores());
			stmt.setString(4, ((Anal) o).getNome_congresso());
			stmt.setInt(5, ((Anal) o).getAno_publicacao());
			stmt.setString(6, ((TrabalhoAcademico) o).getLocal());
			stmt.setInt(7, ((Acervo) o).getId());
			stmt.execute();
			logger.info("Alterações concluídas!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar anal",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada");
		}
		return false;
	}
	
	/**
	 * Método que vai receber um tipo de item Anal e removê-lo do 
	 * banco de dados.
	 *  Ela vai receber um objeto e ira tratar o memso dentro do método.
	 * 
	 * @param  o
	 * */
	
	@Override
	public boolean remove(Object o) throws SQLException {
		String sql = "delete from anais where idanal=?";
		PreparedStatement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, ((Acervo) o).getId());
			stmt.execute();
			logger.info("Exclusão de anal concluída!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir anal",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("conexão encerrada");
		}
		return false;
	}
}
