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

import biblio.Midias;



public  class MidiasDao implements Acervo<Midias>{
	
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(MidiasDao.class);
	
	
	public MidiasDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}
	
	public boolean criar(Midias m) throws SQLException {
		
		PreparedStatement sql =null;
		
		String dataString = m.getDtgravacao();
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date d = null;
		try {
			d = new java.sql.Date(fmt.parse(dataString).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			 sql = conexion.prepareStatement("INSERT INTO midias(titulo,tipo,dtgravacao) VALUES(?,?,?)");
			 sql.setString(1,m.getTitulo());		
			 sql.setString(2,m.getTipo());
			 sql.setDate(3,d);
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

	public boolean editar(String titulo_midia,String troca_titulo)throws SQLException {
		PreparedStatement sql =null;
		MidiasDao md = new MidiasDao();
		try {
			if(md.pesquisar(titulo_midia)==true) {
			sql = conexion.prepareStatement("UPDATE midias SET titulo = ?  WHERE titulo = ?");
			sql.setString(1, troca_titulo);
			sql.setString(2, titulo_midia);
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
		

	public boolean pesquisar(String titulo_midia) throws SQLException {
		PreparedStatement sql =null;
		
		try {
			sql = conexion.prepareStatement("SELECT * FROM midias WHERE titulo = ?");
			sql.setString(1, titulo_midia);
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

	public boolean excluir(String titulo_midia) throws SQLException {
		MidiasDao md = new MidiasDao();
		PreparedStatement sql =null;
		try {
			if(md.pesquisar(titulo_midia) == true) {
			sql = conexion.prepareStatement("DELETE FROM midias WHERE titulo = ?");
			sql.setString(1, titulo_midia);
			sql.executeUpdate();
			
			boolean result = md.pesquisar(titulo_midia);
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