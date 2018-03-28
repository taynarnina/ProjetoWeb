package testes;

import static org.junit.Assert.*;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

import DAO.AnaisDao;
import DAO.Conexao;
import DAO.JornalDao;
import biblio.Jornal;

public class JornalTest {
	
	private static Connection con;
	private PreparedStatement sql;
	
	private static final Logger logger = LogManager.getLogger(JornalTest.class);
	
	@BeforeClass
	public static void testaconexao(){
		try {
			con = Conexao.fazconexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
			
		}	
	}
	
	@AfterClass
	public  static void fecharConexao() {
		try {
			if(!con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("falha!"+e.getMessage());
		}
	}
	
	
	@Test
	public void testCriar() throws SQLException  {
		JornalDao jd = new JornalDao();
		
		Jornal j1 = new Jornal();
		j1.setTitulo("jornal da pb");
		j1.setDtpublic("10/07/2014");
		j1.setEdicao(3);
		
		testaconexao();
		assertTrue(jd.criar(j1));
		fecharConexao();

		/*Jornal j2 = new Jornal();
		j2.setDtpublic("10/07/2014");
		j2.setEdicao(3);
		
		testaconexao();
		//jd.criar(j2);
		fecharConexao();*/
		
	}
	
	@Test(expected = Exception.class)
	public void testEditar() throws SQLException  {
		JornalDao jd = new JornalDao();
		
		testaconexao();
		assertTrue(jd.editar("Jornal da pb","Jornal da manha"));
		fecharConexao();

		testaconexao();
		jd.editar("Jornal da pb","Jornal da manha");
		fecharConexao();
		
		assertFalse(jd.editar("jorn","jornal da manha"));
		
		
	}
	
	@Test(expected = Exception.class)
	public void testPesquisar() throws SQLException  {
		JornalDao jd = new JornalDao();
		
		testaconexao();
		assertTrue(jd.pesquisar("jornal da manha"));
		fecharConexao();

		testaconexao();
		jd.pesquisar("jornal da manha");
		fecharConexao();
		
		testaconexao();
		assertFalse(jd.pesquisar("jorn"));
		fecharConexao();
		
	}
	
	@Test(expected = Exception.class)
	public void testExcluir() throws SQLException  {
		JornalDao jd = new JornalDao();
		
		testaconexao();
		assertTrue(jd.excluir("jornal da manha"));
		fecharConexao();

		testaconexao();
		jd.excluir("jornal da manha");
		fecharConexao();
		
		testaconexao();
		assertFalse(jd.excluir("jorn"));
		fecharConexao();
		
	}



}
