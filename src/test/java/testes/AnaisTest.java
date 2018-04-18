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
	
	private static final Logger logger = LogManager.getLogger(AnaisTest.class);
	
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
		
		a.setTitulo("Estudo de caso engenharia da qualidade");
		a.setTipo("artigo");
		a.setAutores("José da silva,et.al");
		a.setNome_congresso("ENECT");
		a.setAnopublic(2018);
		a.setLocal("Campina grande-PB");
		
		testaconexao();
		boolean result = ad.criar(a);
		assertTrue(result);
		fecharConexao();

		Anais aa = new Anais();
		
		aa.setTipo("artigo");
		aa.setAutores("José da silva,et.al");
		aa.setNome_congresso("ENECT");
		aa.setAnopublic(2018);
		aa.setLocal("Campina grande-PB");
		
		
		testaconexao();
		//ad.criar(aa);
		fecharConexao();
		
	}
	
	@Test(expected = Exception.class)
	public void testEditar() throws SQLException  {
		AnaisDao ad = new AnaisDao();
		
		testaconexao();
		assertTrue(ad.editar("Estudo de caso engenharia da qualidade","engenharia de software"));
		fecharConexao();

		testaconexao();
		ad.editar("Estudo de caso engenharia da qualidade","engenharia de software");
		fecharConexao();
		
		assertFalse(ad.editar("eng","engenharia"));
		
	}
	
	@Test(expected = Exception.class)
	public void testPesquisar() throws SQLException  {
		AnaisDao ad = new AnaisDao();
		
		testaconexao();
		assertTrue(ad.pesquisar("engenharia de software"));
		fecharConexao();

		testaconexao();
		ad.pesquisar("engenharia de software");
		fecharConexao();
		
		testaconexao();
		assertFalse(ad.pesquisar("eng"));
		fecharConexao();
		
	}
	
	@Test(expected = Exception.class)
	public void testExcluir() throws SQLException  {
		AnaisDao ad = new AnaisDao();
		
		testaconexao();
		assertTrue(ad.excluir("engenharia de software"));
		fecharConexao();

		testaconexao();
		ad.excluir("engenharia de software");
		fecharConexao();
		
		testaconexao();
		assertFalse(ad.excluir("engenharia "));
		fecharConexao();
			
	}

}
