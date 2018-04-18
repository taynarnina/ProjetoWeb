package br.edu.ufab.dao.pessoas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.pessoas.Administrador;
/**
 * Classe que vai relacionar os dados de Adiministrador com o banco de dados.
 * @author Murilo Gutavo e Taynar Sousa
 * */
public class AdministradorDao {
	
	private Connection connection;
	private static final Logger logger = LogManager.getLogger(FuncionarioDao.class);
	/**
	 * M�todo que inicializa a conex�o com o banco de dados.
	 * @param connection
	 * */
	public AdministradorDao(Connection connection) {
		this.connection = connection;
	}
	/**
	 * M�todo que recebe os dados de Administrador como par�metro
	 * e adiciona no banco de dados.
	 * @param administrador
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
			
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo administrador",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return false;
	}
	
	public List<Administrador> lista() {
		return null;
		
	}
	/**
	 * M�todo que recebe um id do admiinistrador e realiza a pesquisa dos seus dados.
	 * @param id
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
			
			return administrador;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar administrador por id",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return null;	
	}
	/**
	 * M�todo que recebe um objeto do tipo Administrador e realiza
	 * as altera��es no banco de dados.
	 * @param administrador
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

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar administrador",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
	/**
	 * M�todo que recebe um objeto do tipo Administrador e realiza a remo��o do mesmo.
	 * @param administrador
	 * */
	public boolean remove(Administrador administrador) throws SQLException {
		String sql = "delete from administradores where idadministrador=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, administrador.getId());
			stmt.execute();
			
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir administrador",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
}

