package br.edu.ufab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.Curso;

public class CursoDao {

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(CursoDao.class);
	
	public CursoDao(Connection connection) {
		this.connection = connection;
		logger.info("iniciando conexão...");
	}
	
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
			logger.info("Conexão encerrada!");
		}
		return false;
	}
	
	public List<Curso> lista() {
		logger.info("listando...");
		return null;
		
	}
	
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
			logger.info("pesquisa concluída com sucesso!");
			return curso;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar curso por id",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("Conexão encerrada!");
		}
		return null;
	}
	
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
			logger.info("Dados alterados com sucesso!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar curso",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("Conexão encerrada");
		}
		return false;
	}
	
	public boolean remove(Curso curso) throws SQLException {
		String sql = "delete from cursos where idcurso=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, curso.getId());
			stmt.execute();
			logger.info("Excluído com sucesso!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir curso",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("Conexão encerrada");
		}
		return false;
	}
}