package br.edu.ufab.dao.itens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.itens.Acervo;
import br.edu.ufab.modelo.itens.Anal;
import br.edu.ufab.modelo.itens.TrabalhoAcademico;

public class AnalDao implements ItemDaoIF{
	
	private Connection connection;
	private static final Logger logger = LogManager.getLogger(AnalDao.class);
	
	public AnalDao(Connection connection) {
		this.connection = connection;
	}

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

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo anal",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return false;
	}
	
	@Override
	public List<Object> lista(){
		return null;
		
	}
	
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
			
			return	anal;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar anal por id",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return null;
	}
	
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

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar anal",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
	
	@Override
	public boolean remove(Object o) throws SQLException {
		String sql = "delete from anais where idanal=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, ((Acervo) o).getId());
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
