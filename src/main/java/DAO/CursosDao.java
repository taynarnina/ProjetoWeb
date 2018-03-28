package DAO;


import java.sql.PreparedStatement;
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
			try {
				sql = conexion.prepareStatement("UPDATE cursos SET nome = ?  WHERE nome = ?");
				sql.setString(1, nome_novo);
				sql.setString(2, troca_nome);
				sql.execute();
				
				sql.close();
				conexion.close();
				
				return true;
			} catch (SQLException e) {
				logger.error("falha ao editar!");
				e.printStackTrace();
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
				sql.execute();
				sql.close();
				conexion.close();
				
				return true;
			} catch (SQLException e) {
				logger.error("falha na pesquisa!");
				e.printStackTrace();
			}
			sql.close();
			conexion.close();
			
			return false;
		}


		public boolean excluir(String nome_curso) throws SQLException {
			PreparedStatement sql =null;
			try {
				sql = conexion.prepareStatement("DELETE FROM jornal WHERE titulo = ?");
				sql.setString(1, nome_curso);
				sql.execute();
				
				sql.close();
				conexion.close();
				
				return true;
			} catch (SQLException e) {
				logger.error("falha!");
				e.printStackTrace();
			}
			sql.close();
			conexion.close();
			
			return false;
			
		}
		
	
}