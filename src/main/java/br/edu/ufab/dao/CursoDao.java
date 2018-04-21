package br.edu.ufab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.jdbc.ConnectionFactory;
import br.edu.ufab.modelo.Curso;
/**
 * Classe responsável por fazer a relação da classe Cursos com a tabela cursos
 * no banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa
 * */
public class CursoDao {

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(CursoDao.class);
	
	/**
	 * Método que vai abrir a conexão com o banco de dados
	 * @param connection
	 * */
	public CursoDao(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Método que vai receber um objeto do tipo Curso e vai adicionar seus dados no
	 * banco de dados
	 * @param curso
	 * */
	public boolean adiciona(Curso curso) throws SQLException {
		String sql = "INSERT INTO cursos(nome, codigo, area, tipo) VALUES(?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, curso.getNome());
			stmt.setString(2, curso.getCodigo());
			stmt.setString(3, curso.getArea());
			stmt.setString(4, curso.getTipo());
			stmt.execute();
			logger.info("Dados incluídos com sucesso!");
			return true;
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo curso",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada");
		}
		return false;
	}
	
	/**
	 * Método que vai listar todos os cursos cadastrados no banco de dados
	 * 
	 * */
	
	public List<Curso> lista() {
		return null;
		
	}
	
	/**
	 * Método que vai receber um id de um curso e vai retornar os seus dados.
	 * @param id
	 * */
	
	public Curso pesquisa(int id) throws SQLException {
		String sql = "select * from cursos where idcurso = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Curso curso = new Curso();
			
			while(rs.next()){
				
				//criando o objeto Curso
				curso.setId(rs.getInt("idcurso"));
				curso.setNome(rs.getString("nome"));
				curso.setCodigo(rs.getString("codigo"));
				curso.setArea(rs.getString("area"));
				curso.setTipo(rs.getString("tipo"));
			}
			
			rs.close();
			logger.info("Pesquisa concluída com sucesso!");
			return curso;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar curso por id",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada");
		}
		return null;
	}
	
	/**
	 * Método que vai receber um objeto do tipo curso e alterar seus dados.
	 * @param curso
	 * */
	
	public boolean altera(Curso curso) throws SQLException {
		String sql = "update cursos set nome=?, codigo=?, area=?, tipo=? where idcurso=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, curso.getNome());
			stmt.setString(2, curso.getCodigo());
			stmt.setString(3, curso.getArea());
			stmt.setString(4, curso.getTipo());
			stmt.setInt(5, curso.getId());
			stmt.execute();
			logger.info("Dados alterados com sucesso!!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar curso",e);
			
		} finally {
			stmt.close();
			connection.close();	
			logger.info("conexão encerrada");
		}
		return false;
	}
	
	/**
	 * Método que vai receber um objeto do tipo Curso e excluir o mesmo
	 * do banco de dados.
	 * @param curso
	 * */
	
	public boolean remove(Curso curso) throws SQLException {
		String sql = "delete from cursos where idcurso=?";
		PreparedStatement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, curso.getId());
			stmt.execute();
			logger.info("Curso removido!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir curso",e);
			return false;
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada");
		}
		
	}
}
