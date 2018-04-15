package DAO;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import biblio.Tcc;




public  class TccDao implements Acervo<Tcc> {
	
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(TccDao.class);
	
	
	public TccDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}
	
	public boolean criar(Tcc t) throws SQLException{
		
		PreparedStatement sql =null;
		
		try {
			 sql = conexion.prepareStatement("INSERT INTO tcc(titulo,autor,orientador,tipo,anodefesa,local) VALUES(?,?,?,?,?,?)");
			 sql.setString(1,t.getTitulo());		
			 sql.setString(2,t.getAutor());
			 sql.setString(3,t.getOrientador());
			 sql.setString(4,t.getTipo());
			 sql.setInt(5,t.getAnodefesa());
			 sql.setString(6,t.getLocal());
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

	public boolean editar(String titulo_tcc,String troca_titulo)throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("UPDATE tcc	SET titulo = ?  WHERE titulo = ?");
			sql.setString(1, troca_titulo);
			sql.setString(2, titulo_tcc);
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
		

	public boolean pesquisar(String titulo_tcc) throws SQLException {
		PreparedStatement sql =null;
		try {
			sql = conexion.prepareStatement("SELECT * FROM tcc WHERE titulo = ?");
			sql.setString(1, titulo_tcc);
			sql.execute();
			
			sql.close();
			conexion.close();
			
			return true;
		} catch (SQLException e) {
			logger.error("falha na pesquisa!");
			e.printStackTrace();
			
		}finally {
		sql.close();
		conexion.close();
	}
	
	return false;
	}


	public boolean excluir(String titulo_tcc) throws SQLException {
		TccDao td = new TccDao();
		PreparedStatement sql =null;
		try {
			if(td.pesquisar(titulo_tcc) == true) {
			sql = conexion.prepareStatement("DELETE FROM tcc WHERE titulo = ?");
			sql.setString(1, titulo_tcc);
			sql.execute();
			
			sql.executeUpdate();
			 
			boolean result = td.pesquisar(titulo_tcc);
			if(result == false) {
				return true;
			}
			}
		} catch (SQLException e) {
			logger.error("falha!");
			e.printStackTrace();
		}
		
		sql.close();
		conexion.close();
		
		return false;
		
	}

}