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
import DAO.TccDao;
import biblio.Tcc;

public class TccTest {

	private static Connection con;
	private PreparedStatement sql;
	
	private static final Logger logger = LogManager.getLogger(TccTest.class);
	
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
	public void testCriar() throws SQLException  {
		TccDao td = new TccDao();
		
		Tcc t1 = new Tcc();
		t1.setTitulo("DateBase");
		t1.setAutor("Jk DBC");
		t1.setOrientador("Alan DW");
		t1.setTipo("Monografia");
		t1.setAnodefesa(2017);
		t1.setLocal("CG");
		
		testaconexao();
		assertTrue(td.criar(t1));
		fecharConexao();
		
		
		Tcc t2 = new Tcc();
		t2.setAutor("Jk");
		t2.setOrientador("DW"); 
		t2.setTipo("Monografia");
		t2.setAnodefesa(2017);
		t2.setLocal("CG");
		
		testaconexao();
		td.criar(t2);
		fecharConexao();
	}

	@Test(expected = Exception.class)
	public void testEditar() throws SQLException  {
		TccDao td = new TccDao();
		
		testaconexao();
		assertTrue(td.editar("DateBase", "BancoDeDados"));
		fecharConexao();
		
		testaconexao();
		td.editar("DateBase", "BancoDeDados");
		fecharConexao();
	}
	
	@Test(expected = Exception.class)
	public void testPesquisar() throws SQLException  {
		TccDao td = new TccDao();
		
		testaconexao();
		assertTrue(td.pesquisar("BancoDeDados"));
		fecharConexao();
	
		testaconexao();
		td.pesquisar("DeDados");
		fecharConexao();
	}
	
	@Test(expected = Exception.class)
	public void testExcluir() throws SQLException  {
		TccDao td = new TccDao();
		
		testaconexao();
		assertTrue(td.excluir("BancoDeDados"));
		fecharConexao();
		
		testaconexao();
		td.excluir("Banco");
		fecharConexao();
	
	}
}
