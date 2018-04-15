package DAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import biblio.Jornal;

public  class JornalDao implements Acervo<Jornal> {
	
	private Connection conexion;
	private static final Logger logger = LogManager.getLogger(JornalDao.class);
	private static Date d;
	
	
	
	public JornalDao() throws SQLException {
		conexion = Conexao.fazconexao();
	}
	
	public boolean criar(Jornal j) throws SQLException {
		
		PreparedStatement sql =null;
		String dataString = j.getDtpublic();
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date d = null;
		try {
			d = new java.sql.Date(fmt.parse(dataString).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			logger.error("erro ao transformar"+ e1.getMessage());
			
		}
		
		try {
		 sql = conexion.prepareStatement("INSERT INTO jornal(titulo,data,edicao) VALUES(?,?,?)");
		 sql.setString(1,j.getTitulo());		
		 sql.setDate(2, d);
		 sql.setLong(3,j.getEdicao());
		 sql.execute();
		 System.out.println("inserido");
		
		 return true;
		 
		}catch(SQLException e){
			
			logger.error("erro ao inserir"+e.getMessage());
			
			
		}
		sql.close();
		conexion.close();
		return false;
	}

	public boolean editar(String titulo_jornal,String troca_titulo)throws SQLException {
		PreparedStatement sql =null;
		JornalDao jd = new JornalDao();
		try {
			if(jd.pesquisar(titulo_jornal)==true) {
			sql = conexion.prepareStatement("UPDATE jornal SET titulo = ?  WHERE titulo = ?");
			sql.setString(1, troca_titulo);
			sql.setString(2, titulo_jornal);
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
		

	public boolean pesquisar(String titulo_jornal) throws SQLException {
		PreparedStatement sql =null;
		
		try {
			sql = conexion.prepareStatement("SELECT * FROM jornal WHERE titulo = ?");
			sql.setString(1, titulo_jornal);
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

	public boolean excluir(String titulo_jornal) throws SQLException {
		JornalDao jd = new JornalDao();
		PreparedStatement sql =null;
		try {
			if(jd.pesquisar(titulo_jornal) == true) {
			sql = conexion.prepareStatement("DELETE FROM jornal WHERE titulo = ?");
			sql.setString(1, titulo_jornal);
			sql.executeUpdate();
			
			boolean result = jd.pesquisar(titulo_jornal);
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
