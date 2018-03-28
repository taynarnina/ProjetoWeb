package testes;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

import DAO.Conexao;
import DAO.CursosDao;
import DAO.CursosDao;
import biblio.Cursos;

public class CursosTest {

	private static Connection con;
	private PreparedStatement sql;
	
	private static final Logger logger = LogManager.getLogger(CursosTest.class);
	
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
	
	@Test
	public void testCriar() throws SQLException   {
		CursosDao cd = new CursosDao();
		Cursos c = new Cursos();
		
		c.setNome("Computação");
		c.setArea("TCC");
		c.setTipo("Graduacao");
		
		testaconexao();
		assertTrue(cd.criar(c));
		fecharConexao();
		
	
		
	}
	
	@Test(expected = Exception.class)
	public void testEditar() throws SQLException  {
		CursosDao cd = new CursosDao();
		
		testaconexao();
		assertTrue(cd.editar("Computação","Ciência da computação"));
		fecharConexao();

		testaconexao();
		cd.editar("Computação","Ciência da computação");
		fecharConexao();
		
		assertFalse(cd.editar("Comp","Ciência da computação"));
		
	}
	
	@Test(expected = Exception.class)
	public void testPesquisar() throws SQLException  {
		CursosDao cd = new CursosDao();
		
		testaconexao();
		assertTrue(cd.pesquisar("Ciência da computação"));
		fecharConexao();

		testaconexao();
		cd.pesquisar("Ciência da computação");
		fecharConexao();
		
		testaconexao();
		assertFalse(cd.pesquisar("comp"));
		fecharConexao();

	}
	
	@Test(expected = Exception.class)
	public void testExcluir() throws SQLException  {
		CursosDao cd = new CursosDao();
		
		testaconexao();
		assertTrue(cd.excluir("Ciência da computação"));
		fecharConexao();

		testaconexao();
		cd.excluir("Ciência da computação");
		fecharConexao();
		
		testaconexao();
		assertFalse(cd.excluir("comp"));
		fecharConexao();
	}

}
