package br.edu.ufab.dao.pessoas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.pessoas.Aluno;
/**
 * Classe responsável por fazer a relação dos dados de Aluno com o banco de dados
 * @author Murilo Gustavo e Taynar Sousa
 * */
public class AlunoDao {

	private Connection connection;
	private static final Logger logger = LogManager.getLogger(AlunoDao.class);
	/**
	 * Método que inicializa a conexão com o banco de dados.
	 * @param connection
	 * */
	public AlunoDao(Connection connection) {
		this.connection = connection;
	}
	/**
	 * Método que recebe um objeto do tipo Aluno e realiza um insert no banco de dados.
	 * @param aluno
	 * */
	public boolean adiciona(Aluno aluno) throws SQLException {
		String sql = "INSERT INTO alunos(matricula,cpf,rg,naturalidade,nome,nome_da_mae,endereco,"
		 		+ "telefone,curso,ano,periodo_ingresso,senha) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getMatricula());
			stmt.setString(2, aluno.getCpf());
			stmt.setString(3, aluno.getRg());
			stmt.setString(4, aluno.getNaturalidade());
			stmt.setString(5, aluno.getNome());
			stmt.setString(6, aluno.getNomedamae());
			stmt.setString(7, aluno.getEndereco());
			stmt.setString(8, aluno.getTelefone());
			stmt.setInt(9, aluno.getCurso());
			stmt.setInt(10, aluno.getAno());
			stmt.setString(11, aluno.getPeriodo_ingresso());
			stmt.setString(12, aluno.getSenha());
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo aluno",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return false;
	}
	/**
	 * Método que vai listar todos os alunos cadastrados no banco de dados.
	 * 
	 * */
	public List<Aluno> lista() {
		return null;
		
	}
	/**
	 * Método que realiza a pesquisa dos dados de aluno a partir do seu id.
	 * @param id
	 * */
	public Aluno pesquisa(int id) throws SQLException {
		String sql = "select * from alunos where idaluno = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Aluno aluno = new Aluno();
			
			while(rs.next()){
				
				//criando o objeto Aluno
				aluno.setId(rs.getInt("idaluno"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setRg(rs.getString("rg"));
				aluno.setNaturalidade(rs.getString("naturalidade"));
				aluno.setNome(rs.getString("nome"));
				aluno.setNomedamae(rs.getString("nome_da_mae"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setCurso(rs.getInt("curso"));
				aluno.setAno(rs.getInt("ano"));
				aluno.setPeriodo_ingresso(rs.getString("periodo_ingresso"));
				aluno.setSenha(rs.getString("senha"));
			}
			
			rs.close();
			
			return	aluno;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar aluno por id",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return null;
	}
	/**
	 * Método que recebe um objeto do tipo Aluno e faz a alteração
	 * dos seus dados no banco de dados.
	 * @param aluno
	 * */
	public boolean altera(Aluno aluno) throws SQLException {
		String sql = "update alunos set matricula=?, cpf=?, rg=?, naturalidade=?, nome=?,"
				+ "nome_da_mae=?, endereco=?, telefone=?, curso=?, ano=?, periodo_ingresso=?,"
				+ "senha=? where idaluno=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getMatricula());
			stmt.setString(2, aluno.getCpf());
			stmt.setString(3, aluno.getRg());
			stmt.setString(4, aluno.getNaturalidade());
			stmt.setString(5, aluno.getNome());
			stmt.setString(6, aluno.getNomedamae());
			stmt.setString(7, aluno.getEndereco());
			stmt.setString(8, aluno.getTelefone());
			stmt.setInt(9, aluno.getCurso());
			stmt.setInt(10, aluno.getAno());
			stmt.setString(11, aluno.getPeriodo_ingresso());
			stmt.setString(12, aluno.getSenha());
			stmt.setInt(13, aluno.getId());
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar aluno",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
	/**
	 * Método que recebe um Aluno como parâmetro e realiza a remoção dos seus dados no banco de dados.
	 * @param aluno
	 * */
	public boolean remove(Aluno aluno) throws SQLException {
		String sql = "delete from alunos where idaluno=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, aluno.getId());
			stmt.execute();
			
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir aluno",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
}
