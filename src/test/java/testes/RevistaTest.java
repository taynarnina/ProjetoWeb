package testes;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

import DAO.Conexao;
import DAO.RevistaDao;
import DAO.RevistaDao;
import biblio.Revista;

public class RevistaTest {

	private static Connection con;
	private PreparedStatement sql;
	
	private static final Logger logger = LogManager.getLogger(RevistaTest.class);
	
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
		RevistaDao rd = new RevistaDao();
		Revista r = new Revista();
		
		r.setTitulo("Caras e bocas");
		r.setEditora("Abril");
		r.setDtpublicacao("09/04/2017");
		r.setEdicao(5);
		r.setNumpaginas(113);
		
		testaconexao();
		assertTrue(rd.criar(r));
		fecharConexao();
		
		Revista rr = new Revista();
		
		rr.setEditora("Abril");
		rr.setDtpublicacao("09/04/2017");
		rr.setEdicao(5);
		rr.setNumpaginas(113);
		
		testaconexao();
		assertTrue(rd.criar(rr));
		fecharConexao();
	
		
	}
	
	@Test(expected = Exception.class)
	public void testEditar() throws SQLException  {
		RevistaDao rd = new RevistaDao();
		
		testaconexao();
		assertTrue(rd.editar("Caras e bocas","Cobras"));
		fecharConexao();

		testaconexao();
		rd.editar("Jornal da pb","Jornal da manha");
		fecharConexao();
		
		assertFalse(rd.editar("jorn","jornal da manha"));
		
	}
	
	@Test(expected = Exception.class)
	public void testPesquisar() throws SQLException  {
		RevistaDao rd = new RevistaDao();
		
		testaconexao();
		assertTrue(rd.pesquisar("Cobras"));
		fecharConexao();

		testaconexao();
		rd.pesquisar("jornal da manha");
		fecharConexao();
		
		testaconexao();
		assertFalse(rd.pesquisar("jorn"));
		fecharConexao();
		
	}
	
	@Test(expected = Exception.class)
	public void testExcluir() throws SQLException  {
		RevistaDao rd = new RevistaDao();
		
		testaconexao();
		assertTrue(rd.excluir("Cobras"));
		fecharConexao();

		testaconexao();
		rd.excluir("jornal da manha");
		fecharConexao();
		
		testaconexao();
		assertFalse(rd.excluir("jorn"));
		fecharConexao();
	}

}
