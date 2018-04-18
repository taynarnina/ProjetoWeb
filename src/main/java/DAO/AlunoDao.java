package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;

import ufab.Aluno;

public class AlunoDao  implements Acervo<Aluno>{
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(AnaisDao.class);
	
	public AlunoDao() {
		try {
			conexion =Conexao.fazconexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("finally")
	public boolean criar(Aluno c) throws SQLException {
		PreparedStatement sql =null;
		try {
			 sql = conexion.prepareStatement("INSERT INTO aluno(cpf,rg,naturalidade,nome,nomemae,endereco,"
			 		+ "telefone,curso,anoingresso,periodo,senha) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			 sql.setString(1,c.getCpf());		
			 sql.setString(2,c.getRg());
			 sql.setString(3,c.getNaturalidade());
			 sql.setString(4,c.getNome());
			 sql.setString(5,c.getNomedamae());
			 sql.setString(6,c.getEndereco());
			 sql.setString(7,c.getTelefone());
			 sql.setString(8,c.getCurso());
			 sql.setInt(9,c.getAnoingresso());
			 sql.setInt(10,Aluno.getPeriodo());
			 sql.setString(11,c.getSenha());
			 sql.execute();
			 
			 sql.close();
			 conexion.close();
			 
			 return true;
		}catch(SQLException a){

			logger.error(a.getMessage());
			
			return false;
		}finally {
			sql.close();
			conexion.close();
		}
	}

	public boolean editar(String nome_aluno,String nome_a_trocar) throws SQLException {
		PreparedStatement sql =null;
		AlunoDao ad = new AlunoDao();
		try {
			if(ad.pesquisar(nome_aluno)==true) {
			sql = conexion.prepareStatement("UPDATE aluno SET nome = ?  WHERE nome = ?");
			sql.setString(1, nome_a_trocar);
			sql.setString(2, nome_aluno);
			sql.execute();
			return true;
			}
		} catch (SQLException e) {
			logger.error("falha ao editar!"+ e.getMessage());
			
		}finally {
			sql.close();
			conexion.close();
		}
		
		return false;
	}

	public boolean pesquisar(String nome_aluno) throws SQLException {
		PreparedStatement sql =null;
		
		try {
			sql = conexion.prepareStatement("SELECT * FROM aluno WHERE nome = ?");
			sql.setString(1, nome_aluno);
			ResultSet result =sql.executeQuery();
			
			return result.next();
		} catch (SQLException e) {
			logger.error("falha na pesquisa!");
			return false;
			
		}finally {
			sql.close();
			conexion.close();
		}
		
	}

	public boolean excluir(String matricula) throws SQLException {
		AlunoDao ad = new AlunoDao();
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("DELETE FROM aluno WHERE matricula = ?");
			sql.setString(1, matricula);
			sql.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			logger.error("falha!");
			e.printStackTrace();
		}finally {
			sql.close();
			conexion.close();
		}
		return false;
	}


}
