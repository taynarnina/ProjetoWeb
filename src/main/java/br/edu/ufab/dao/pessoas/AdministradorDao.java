package br.edu.ufab.dao.pessoas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.jdbc.ConnectionFactory;
import br.edu.ufab.modelo.pessoas.Administrador;
/**
 * Classe responsável por fazer a relação entre a classe Administrador e a tabela
 * administrador no banco de dados.
 * 
 * @author Taynar Sousa e Murilo Gustavo
 * */
public class AdministradorDao {
	
	private Connection connection;
	private static final Logger logger = LogManager.getLogger(FuncionarioDao.class);
	
	/**
	 * Método que vai abrir a conexão com o banco de dados
	 * @param connection
	 * */
	
	public AdministradorDao(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Método que vai receber um objeto do tipo Administrador e adiciona seus dados no
	 * banco de dados
	 * 
	 * @param  administrador
	 * */
	
	
	public boolean adiciona(Administrador administrador) throws SQLException {
		String sql = "INSERT INTO administradores(cpf,rg,nome,naturalidade,endereco,telefone,"
				+ "email,usuario,senha) VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, administrador.getCpf());
			stmt.setString(2, administrador.getRg());
			stmt.setString(3, administrador.getNome());
			stmt.setString(4, administrador.getNaturalidade());
			stmt.setString(5, administrador.getEndereco());
			stmt.setString(6, administrador.getTelefone());
			stmt.setString(7, administrador.getEmail());
			stmt.setString(8, administrador.getUsuario());
			stmt.setString(9, administrador.getSenha());
			stmt.execute();
			logger.info("Administrador inserido com sucesso!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo administrador",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada!");
		}
		return false;
	}
	
	/**
	 * Método que vai listar todos administradores cadastrados
	 * 
	 * */
	
	public List<Administrador> lista() {
		logger.info("gerando lista...");
		return null;
		
	}
	
	/**
	 * Método que vai receber o id de Administrador e irá retornar os seus dados.	 
	 * 
	 * @param  id
	 * */
	
	public Administrador pesquisa(int id) throws SQLException {
		String sql = "select * from administradores where idadministrador = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Administrador administrador = new Administrador();
			
			while(rs.next()){
				
				//criando o objeto Admistrador
				administrador.setId(rs.getInt("idadministrador"));
				administrador.setCpf(rs.getString("cpf"));
				administrador.setRg(rs.getString("rg"));
				administrador.setNome(rs.getString("nome"));
				administrador.setNaturalidade(rs.getString("naturalidade"));
				administrador.setEndereco(rs.getString("endereco"));
				administrador.setTelefone(rs.getString("telefone"));
				administrador.setEmail(rs.getString("email"));
				administrador.setUsuario(rs.getString("usuario"));
				administrador.setSenha(rs.getString("senha"));
				
			}
			
			rs.close();
			logger.info("Pesquisa concluída com sucesso!");
			return administrador;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar administrador por id",e);
		} finally {
			stmt.close();
			connection.close();
			logger.info("conexão encerrada!");
		}
		return null;	
	}
	
	/**
	 * Método que vai receber um objeto do tipo Administrador e vai alterar seus dados no
	 * banco de dados.
	 * 
	 * @param  administrador
	 * */
	
	public boolean altera(Administrador administrador) throws SQLException {
		String sql = "update administradores set cpf=?, rg=?, nome=?, naturalidade=?,"
				+ "endereco=?, telefone=?, email=?, usuario=?, senha=?"
				+ "where idadministrador=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, administrador.getCpf());
			stmt.setString(2, administrador.getRg());
			stmt.setString(3, administrador.getNome());
			stmt.setString(4, administrador.getNaturalidade());
			stmt.setString(5, administrador.getEndereco());
			stmt.setString(6, administrador.getTelefone());
			stmt.setString(7, administrador.getEmail());
			stmt.setString(8, administrador.getUsuario());
			stmt.setString(9, administrador.getSenha());
			stmt.setInt(10, administrador.getId());
			stmt.execute();
			logger.info("Alterações em administrador concluídas!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar administrador",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("conexão encerrada!");
		}
		return false;
	}
	
	/**
	 * Método que vai receber um objeto do tipo Administrador e vai remover seus dados do
	 * banco de dados.
	 * 
	 * @param  administrador
	 * */
	public boolean remove(Administrador administrador) throws SQLException {
		String sql = "delete from administradores where idadministrador=?";
		PreparedStatement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, administrador.getId());
			stmt.execute();
			logger.info("Administrador excluído com sucesso!!");
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir administrador",e);
		} finally {
			stmt.close();
			connection.close();	
			logger.info("conexão encerrada!");
		}
		return false;
	}
}

