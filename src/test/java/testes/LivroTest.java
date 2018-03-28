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
import DAO.LivroDao;
import DAO.LivroDao;
import biblio.Livro;


public class LivroTest {
	private static Connection con;
	private PreparedStatement sql;
	
	private static final Logger logger = LogManager.getLogger(LivroTest.class);
	
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
		LivroDao ld = new LivroDao();
		Livro l = new Livro();
		
		l.setTitulo("Programação web para leigos");
		l.setAutor("Thiago Batista");
		l.setIsbn(78945);
		l.setEditora("Novatec");
		l.setAnopublic(2017);
		l.setNumpaginas(300);
		l.setArea_conhecimento("programação");
		l.setTema("programação web");
		
		testaconexao();
		assertTrue(ld.criar(l));
		fecharConexao();
		
		Livro ll = new Livro();
		
		ll.setAutor("Thiago Batista");
		ll.setIsbn(78945);
		ll.setEditora("Novatec");
		ll.setAnopublic(2017);
		ll.setNumpaginas(300);
		ll.setArea_conhecimento("programação");
		ll.setTema("programação web");
		
		testaconexao();
		assertTrue(ld.criar(ll));
		fecharConexao();
	}
	
	@Test(expected = Exception.class)
	public void testEditar() throws SQLException  {
		LivroDao ld = new LivroDao();
		
		testaconexao();
		assertTrue(ld.editar("Programação web para leigos","Programação web"));
		fecharConexao();

		testaconexao();
		ld.editar("Programação web para leigos","Programação web");
		fecharConexao();
		
		assertFalse(ld.editar("POG","Programação web"));
		
	}
	
	@Test(expected = Exception.class)
	public void testPesquisar() throws SQLException  {
		LivroDao ld = new LivroDao();
		
		testaconexao();
		assertTrue(ld.pesquisar("Programação web"));
		fecharConexao();

		testaconexao();
		ld.pesquisar("Programação web");
		fecharConexao();
		
		testaconexao();
		assertFalse(ld.pesquisar("POG"));
		fecharConexao();
		
	}
	
	@Test(expected = Exception.class)
	public void testExcluir() throws SQLException  {
		LivroDao ld = new LivroDao();
		
		testaconexao();
		assertTrue(ld.excluir("Programação web"));
		fecharConexao();

		testaconexao();
		ld.excluir("Programação web");
		fecharConexao();
		
		testaconexao();
		assertFalse(ld.excluir("POG"));
		fecharConexao();
	}

}
