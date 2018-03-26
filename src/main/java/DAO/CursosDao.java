package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;

import biblio.Cursos;



public  class CursosDao {
		
		private Connection conexion;
		private static final Logger logger = LogManager.getLogger(LivroDao.class);
		
		
		public CursosDao() throws SQLException {
			conexion = Conexao.fazconexao();
		}


		public void criar(Cursos c) throws SQLException  {
			PreparedStatement sql =null;
			try {
			 sql = conexion.prepareStatement("INSERT INTO cursos(nome,area,tipo) VALUES(?,?,?)");
			 sql.setString(1,c.getNome());		
			 sql.setString(2,c.getArea());
			 sql.setString(3,c.getTipo());
			 sql.execute();
			}catch(SQLException e){
				logger.error("erro na inserção dos dados!");
				throw new SQLException(e.getMessage());
				
			}
			sql.close();
			conexion.close();
			
		}


		public void editar(String troca_nome, String nome_novo) throws SQLException {
			PreparedStatement sql =null;
			try {
				sql = conexion.prepareStatement("UPDATE jornal	SET titulo = ?  WHERE titulo = ?");
				sql.setString(1, nome_novo);
				sql.setString(2, troca_nome);
				sql.execute();
			} catch (SQLException e) {
				logger.error("falha ao editar!");
				e.printStackTrace();
			}
			sql.close();
			conexion.close();
			
		}


		public void excluir(String nome_curso) throws SQLException {
			PreparedStatement sql =null;
			try {
				sql = conexion.prepareStatement("DELETE FROM jornal WHERE titulo = ?");
				sql.setString(1, nome_curso);
				sql.execute();
			} catch (SQLException e) {
				logger.error("falha!");
				e.printStackTrace();
			}
			sql.close();
			conexion.close();
			
		}
		
	
}
