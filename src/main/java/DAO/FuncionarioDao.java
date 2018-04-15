package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;


import biblio.Funcionario;

public class FuncionarioDao {

	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(CursosDao.class);
	
	
	public FuncionarioDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}


	public boolean criar(Funcionario f) throws SQLException  {
		PreparedStatement sql =null;
		try {
		 sql = conexion.prepareStatement("INSERT INTO funcionario(cpf,rg,nome,naturalidade,endereco,"
		 		+ "telefone,email,usuario,senha,nivel) VALUES(?,?,?,?,?,?,?,?,?,?)");
		 sql.setString(1,f.getCpf());		
		 sql.setString(2,f.getRg());
		 sql.setString(3,f.getNome());
		 sql.setString(4,f.getNaturalidade());
		 sql.setString(5,f.getEndereço());
		 sql.setString(6,f.getTelefone());
		 sql.setString(7,f.getEmail());
		 sql.setString(8,f.getUsuario());
		 sql.setString(9,f.getSenha());
		 sql.execute();
		 
		 return true;
		}catch(SQLException e){
			logger.error(e.getMessage());
			
		}finally {
			sql.close();
			conexion.close();
		}
		
		return false;
		
	}


	public boolean editar(String troca_nome, String nome_novo) throws SQLException {
		PreparedStatement sql =null;
		FuncionarioDao fd = new FuncionarioDao();
		try {
			if(fd.pesquisar(troca_nome)==true) {
			sql = conexion.prepareStatement("UPDATE funcionario SET nome = ?  WHERE nome = ?");
			sql.setString(1, nome_novo);
			sql.setString(2, troca_nome);
			sql.execute();
			return true;
			}
		} catch (SQLException e) {
			logger.error("falha ao editar!"+e.getMessage());
			
		}finally {
			sql.close();
			conexion.close();
		}
		return false;
		
	}
	
	public boolean pesquisar(String nome) throws SQLException {
		PreparedStatement sql =null;
		
		try {
			sql = conexion.prepareStatement("SELECT * FROM funcionario WHERE nome = ?");
			sql.setString(1, nome);
			ResultSet result =sql.executeQuery();
			
	
			return result.next();
			
		} catch (SQLException e) {
			logger.error("falha na pesquisa!"+ e.getMessage());
			
		}finally {
			sql.close();
			conexion.close();
		}
		
		
		return false;
	}


	public boolean excluir(String nome_funcionario) throws SQLException {
		PreparedStatement sql =null;
		try {
		
			sql = conexion.prepareStatement("DELETE FROM funcionario WHERE nome = ?");
			sql.setString(1, nome_funcionario);
			sql.executeUpdate();
			
			
		} catch (SQLException e) {
			logger.error("falha!"+e.getMessage());
			
		}finally {
			sql.close();
			conexion.close();
		}
		return false;
		
	}
}
