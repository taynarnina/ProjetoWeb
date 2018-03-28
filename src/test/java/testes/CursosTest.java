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
	
	@Test(expected = Exception.class)
	public void testCriar() throws SQLException   {
		CursosDao cd = new CursosDao();
		Cursos c = new Cursos();
		
		c.setNome("Computação");
		c.setArea("TCC");
		c.setTipo("Graduacao");
		
		testaconexao();
		assertTrue(cd.criar(c));
		fecharConexao();
		
		Cursos cc = new Cursos();
		
		cc.setNome("Computação");
		cc.setArea("TCC");
		cc.setTipo("Graduacao");
		
		testaconexao();
		cd.criar(cc);
		fecharConexao();
		
	}
	
	@Test(expected = Exception.class)
	public void testEditar() throws SQLException  {
		CursosDao cd = new CursosDao();
		
		testaconexao();
		assertTrue(cd.editar("Computacao","CC"));
		fecharConexao();
		
		testaconexao();
		cd.editar("Computacao","CC");
		fecharConexao();
		
	}
	
	@Test(expected = Exception.class)
	public void testPesquisar() throws SQLException  {
		CursosDao cd = new CursosDao();
		
		testaconexao();
		assertTrue(cd.pesquisar("CC"));
		fecharConexao();
		
		testaconexao();
		cd.pesquisar("CC");
		fecharConexao();

	}

}
