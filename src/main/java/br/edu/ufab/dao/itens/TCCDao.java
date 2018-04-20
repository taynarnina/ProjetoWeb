package br.edu.ufab.dao.itens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.itens.Acervo;
import br.edu.ufab.modelo.itens.TCC;
import br.edu.ufab.modelo.itens.TrabalhoAcademico;

public class TCCDao implements ItemDaoIF{

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(TCCDao.class);
	
	public TCCDao(Connection connection) {
		this.connection = connection;
	}
	
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
	
	@Override
	public List<Object> lista(){
		return null;
		
	}
	
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
			
			return	tcc;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar tcc por id",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return null;
	}
	
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

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar tcc",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
	
	@Override
	public boolean remove(Object o) throws SQLException {
		String sql = "delete from tcc where idtcc=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, ((Acervo) o).getId());
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
