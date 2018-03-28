package DAO;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import biblio.Revista;



public  class RevistaDao implements Acervo<Revista> {
	
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(RevistaDao.class);
	
	
	public RevistaDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}
	
	public boolean criar(Revista r) throws SQLException {
		
		PreparedStatement sql =null;
		
		String dataString = r.getDtpublicacao();
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date d = null;
		try {
			d = new java.sql.Date(fmt.parse(dataString).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		 sql = conexion.prepareStatement("INSERT INTO revista(titulo,editora,dtpublicacao,edicao,numpaginas) VALUES(?,?,?,?,?)");
		 sql.setString(1,r.getTitulo());		
		 sql.setString(2,r.getEditora());
		 sql.setDate(3,d);
		 sql.setInt(4,r.getEdicao());
		 sql.setInt(5,r.getNumpaginas());
		 sql.execute();
		 
		 return true;
		}catch(SQLException e){
			
			logger.error(e.getMessage());
		
		}
		sql.close();
		conexion.close();
		
		return false;
		
	}

	public boolean editar(String titulo_revista,String troca_titulo)throws SQLException {
		PreparedStatement sql =null;
		RevistaDao jd = new RevistaDao();
		try {
			if(jd.pesquisar(titulo_revista)==true) {
			sql = conexion.prepareStatement("UPDATE revista SET titulo = ?  WHERE titulo = ?");
			sql.setString(1, troca_titulo);
			sql.setString(2, titulo_revista);
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
		

	public boolean pesquisar(String titulo_revista) throws SQLException {
		PreparedStatement sql =null;
		
		try {
			sql = conexion.prepareStatement("SELECT * FROM revista WHERE titulo = ?");
			sql.setString(1, titulo_revista);
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


	public boolean excluir(String titulo_revista) throws SQLException {
		RevistaDao rd = new RevistaDao();
		PreparedStatement sql =null;
		try {
			if(rd.pesquisar(titulo_revista) == true) {
			sql = conexion.prepareStatement("DELETE FROM revista WHERE titulo = ?");
			sql.setString(1, titulo_revista);
			sql.executeUpdate();
			
			boolean result = rd.pesquisar(titulo_revista);
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
