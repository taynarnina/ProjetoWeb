package DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;

import biblio.Cursos;



public  class CursosDao {
		
		private Connection conexion;
		private static final Logger logger = LogManager.getLogger(CursosDao.class);
		
		
		public CursosDao() throws SQLException {
			conexion = Conexao.fazconexao();
		}


		public boolean criar(Cursos c) throws SQLException  {
			PreparedStatement sql =null;
			try {
			 sql = conexion.prepareStatement("INSERT INTO cursos(nome,area,tipo) VALUES(?,?,?)");
			 sql.setString(1,c.getNome());		
			 sql.setString(2,c.getArea());
			 sql.setString(3,c.getTipo());
			 sql.execute();
			 
			 sql.close();
			 conexion.close();
			 
			 return true;
			}catch(SQLException e){
				logger.error(e.getMessage());
				
			}
			sql.close();
			conexion.close();
			
			return false;
			
		}


		public boolean editar(String troca_nome, String nome_novo) throws SQLException {
			PreparedStatement sql =null;
			CursosDao cd = new CursosDao();
			try {
				if(cd.pesquisar(troca_nome)==true) {
				sql = conexion.prepareStatement("UPDATE cursos SET nome = ?  WHERE nome = ?");
				sql.setString(1, nome_novo);
				sql.setString(2, troca_nome);
				sql.execute();
				return true;
				}
			} catch (SQLException e) {
				logger.error("falha ao editar!"+e.getMessage());
				
			}
			sql.close();
			conexion.close();
			
			return false;
			
		}
		
		public boolean pesquisar(String nome) throws SQLException {
			PreparedStatement sql =null;
			
			try {
				sql = conexion.prepareStatement("SELECT * FROM cursos WHERE nome = ?");
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


		public boolean excluir(String nome_curso) throws SQLException {
			CursosDao cd = new CursosDao();
			PreparedStatement sql =null;
			try {
				if(cd.pesquisar(nome_curso) == true) {
				sql = conexion.prepareStatement("DELETE FROM cursos WHERE nome = ?");
				sql.setString(1, nome_curso);
				sql.executeUpdate();
				
				boolean result = cd.pesquisar(nome_curso);
				if(result == false) {
					return true;
				}
				}
				
			} catch (SQLException e) {
				logger.error("falha!"+e.getMessage());
				
			}
			sql.close();
			conexion.close();
			
			return false;
			
		}
		
	
}