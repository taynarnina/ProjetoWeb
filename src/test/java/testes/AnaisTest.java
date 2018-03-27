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
import biblio.Anais;


public class AnaisTest {
	
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
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	@Before
	
	
	@Test
	public void testCriar() throws SQLException  {
		AnaisDao ad = new AnaisDao();
		Anais a = new Anais();
		
		a.setTitulo("Estudo de caso sobre engenharia da qualidade do software");
		a.setTipo("artigo");
		a.setAutores("Jos� da silva,et.al");
		a.setNome_congresso("ENECT");
		a.setAnopublic(2018);
		a.setLocal("Campina grande-PB");
		
		
		testaconexao();
		assertTrue(ad.criar(a));
		fecharConexao();

	
		
	}
	
	@Test
	public void testEditar() throws SQLException  {
		AnaisDao ad = new AnaisDao();
		
		testaconexao();
		assertTrue(ad.editar("Estudo de caso sobre engenharia da qualidade do software","engenharia de software"));
		fecharConexao();

	
		
	}
	
	@Test
	public void testPesquisar() throws SQLException  {
		AnaisDao ad = new AnaisDao();
		
		testaconexao();
		assertTrue(ad.pesquisar("engenharia de software"));
		fecharConexao();

	
		
	}
	
	@Test
	public void testExcluir() throws SQLException  {
		AnaisDao ad = new AnaisDao();
		
		testaconexao();
		assertTrue(ad.excluir("engenharia de software"));
		fecharConexao();

	
		
	}



}