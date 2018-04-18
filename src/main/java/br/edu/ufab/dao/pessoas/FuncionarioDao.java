package br.edu.ufab.dao.pessoas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.edu.ufab.modelo.pessoas.Funcionario;
/**
 * Classe respons�vel por fazer a rela��o dos dados de Funcionario com o banco de dados
 * @author Murilo Gustavo e Taynar Sousa
 * */
public class FuncionarioDao {
	
	private Connection connection;
	private static final Logger logger = LogManager.getLogger(FuncionarioDao.class);
	/**
	 * M�todo que inicializa a conex�o com o banco de dados.
	 * @param connection
	 * */
	public FuncionarioDao(Connection connection) {
		this.connection = connection;
	}
	/**
	 * M�todo que recebe um objeto do tipo Funcionario e realiza um insert no banco de dados.
	 * @param funcionario
	 * */
	public boolean adiciona(Funcionario funcionario) throws SQLException {
		String sql = "INSERT INTO funcionarios(cpf,rg,nome,naturalidade,endereco,telefone,"
				+ "email,usuario,senha) VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getCpf());
			stmt.setString(2, funcionario.getRg());
			stmt.setString(3, funcionario.getNome());
			stmt.setString(4, funcionario.getNaturalidade());
			stmt.setString(5, funcionario.getEndereco());
			stmt.setString(6, funcionario.getTelefone());
			stmt.setString(7, funcionario.getEmail());
			stmt.setString(8, funcionario.getUsuario());
			stmt.setString(9, funcionario.getSenha());
			stmt.execute();		

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao adicionar novo funcionario",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return false;
	}
	/**
	 * M�todo que vai listar todos os livros cadastrados no banco de dados.
	 * 
	 * */
	public List<Funcionario> lista() {
		return null;
		
	}
	/**
	 * M�todo que realiza a pesquisa dos dados de um funcionario a partir do seu id.
	 * @param id
	 * */
	public Funcionario pesquisa(int id) throws SQLException {
		String sql = "select * from funcionarios where idfuncionario = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Funcionario funcionario = new Funcionario();
			
			while(rs.next()){
				
				//criando o objeto Funcionario
				funcionario.setId(rs.getInt("idfuncionario"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setRg(rs.getString("rg"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setNaturalidade(rs.getString("naturalidade"));
				funcionario.setEndereco(rs.getString("endereco"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
				
			}
			
			rs.close();
			
			return funcionario;
			
		} catch (SQLException e){
			logger.error("Erro ao pesquisar funcionario por id",e);
		} finally {
			stmt.close();
			connection.close();
		}
		return null;	
	}
	/**
	 * M�todo que recebe um objeto do tipo Funionario e faz a altera��o no banco de dados.
	 * @param funcionario
	 * */
	public boolean altera(Funcionario funcionario) throws SQLException {
		String sql = "update funcionarios set cpf=?, rg=?, nome=?, naturalidade=?,"
				+ "endereco=?, telefone=?, email=?, usuario=?, senha=?"
				+ "where idfuncionario=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getCpf());
			stmt.setString(2, funcionario.getRg());
			stmt.setString(3, funcionario.getNome());
			stmt.setString(4, funcionario.getNaturalidade());
			stmt.setString(5, funcionario.getEndereco());
			stmt.setString(6, funcionario.getTelefone());
			stmt.setString(7, funcionario.getEmail());
			stmt.setString(8, funcionario.getUsuario());
			stmt.setString(9, funcionario.getSenha());
			stmt.setInt(10, funcionario.getId());
			stmt.execute();

			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao alterar funcionario",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
	/**
	 * M�todo que recebe um funcionario como par�metro e realiza a remo��o do funcionario no banco de dados.
	 * @param funcionario
	 * */
	public boolean remove(Funcionario funcionario) throws SQLException {
		String sql = "delete from funcionarios where idfuncionario=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, funcionario.getId());
			stmt.execute();
			
			return true;
			
		} catch (SQLException e){
			logger.error("Erro ao excluir funcionario",e);
		} finally {
			stmt.close();
			connection.close();	
		}
		return false;
	}
}
