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
import DAO.MidiasDao;
import DAO.RevistaDao;
import biblio.Midias;
import biblio.Revista;

public class MidiasTest {
	
	private static Connection con;
	private PreparedStatement sql;
	
	private static final Logger logger = LogManager.getLogger(MidiasTest.class);

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
		MidiasDao md= new MidiasDao();
		Midias m = new Midias();
		
		m.setTitulo("Telecurso 2000");
		m.setTipo("dvd");
		m.setDtgravacao("20/03/2000");
		
		testaconexao();
		assertTrue(md.criar(m));
		fecharConexao();

	
		
	}
	
	@Test
	public void testEditar() throws SQLException  {
		MidiasDao md = new MidiasDao();
		
		testaconexao();
		assertTrue(md.editar("Telecurso 2000","Telecurso 1999"));
		fecharConexao();

	
		
	}
	
	@Test
	public void testPesquisar() throws SQLException  {
		MidiasDao md = new MidiasDao();
		
		testaconexao();
		assertTrue(md.pesquisar("Telecurso 1999"));
		fecharConexao();

	
		
	}
	
	@Test
	public void testExcluir() throws SQLException  {
		MidiasDao md = new MidiasDao();
		
		testaconexao();
		assertTrue(md.excluir("Telecurso 1999"));
		fecharConexao();

	
		
	}

}
