package br.edu.ufab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.Curso;
/**
 * Classe respons�vel por fazer a rela��o dos dados de Curso com o banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa
 */
public class CursoDao {

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(CursoDao.class);
	
	public CursoDao(Connection connection) {
		this.connection = connection;
	}
	/**
	 * M�todo que recebe dados do tipo Curso e adiciona no banco de dados.
	 * @param curso
	 */
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
			
			return true;
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo curso",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return false;
	}
	
	public List<Curso> lista() {
		return null;
		
	}
	/**
	 * M�todo que pesquisa um curso a partir do id do curso.
	 * @param id
	 */
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
		
			return curso;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar curso por id",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return null;
	}
	/**
	 * M�todo que faz altera��o dos dados de Curso no banco de dados
	 * @param curso
	 */
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

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar curso",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
	/**
	 * M�todo que remove todos os dados de Curso no banco de dados
	 * @param curso
	 */
	public boolean remove(Curso curso) throws SQLException {
		String sql = "delete from cursos where idcurso=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, curso.getId());
			stmt.execute();
			
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir curso",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
}
