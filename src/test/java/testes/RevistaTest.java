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
import biblio.Revista;

public class RevistaTest {

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

	
		
	}
	
	@Test
	public void testEditar() throws SQLException  {
		RevistaDao rd = new RevistaDao();
		
		testaconexao();
		assertTrue(rd.editar("Caras e bocas","Caras Brasil"));
		fecharConexao();

	
		
	}
	
	@Test
	public void testPesquisar() throws SQLException  {
		RevistaDao rd = new RevistaDao();
		
		testaconexao();
		assertTrue(rd.pesquisar("Caras Brasil"));
		fecharConexao();

	
		
	}
	
	@Test
	public void testExcluir() throws SQLException  {
		RevistaDao rd = new RevistaDao();
		
		testaconexao();
		assertTrue(rd.excluir("Caras Brasil"));
		fecharConexao();

	
		
	}

}
