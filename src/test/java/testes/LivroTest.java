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
import biblio.Livro;


public class LivroTest {
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
		LivroDao ld = new LivroDao();
		Livro l = new Livro();
		
		l.setTitulo("Programa��o web para leigos");
		l.setAutor("Thiago Batista");
		l.setIsbn(78945);
		l.setEditora("Novatec");
		l.setAnopublic(2017);
		l.setNumpaginas(300);
		l.setArea_conhecimento("programa��o");
		l.setTema("programa��o web");
		
		testaconexao();
		assertTrue(ld.criar(l));
		fecharConexao();

	
		
	}
	
	@Test
	public void testEditar() throws SQLException  {
		LivroDao ld = new LivroDao();
		
		testaconexao();
		assertTrue(ld.editar("Programa��o web para leigos","Programa��o para leigos"));
		fecharConexao();

	
		
	}
	
	@Test
	public void testPesquisar() throws SQLException  {
		LivroDao ld = new LivroDao();
		
		testaconexao();
		assertTrue(ld.pesquisar("Programa��o para leigos"));
		fecharConexao();

	
		
	}
	
	@Test
	public void testExcluir() throws SQLException  {
		LivroDao ld = new LivroDao();
		
		
		testaconexao();
		assertTrue(ld.excluir("Programa��o para leigos"));
		fecharConexao();

	
		
	}

}
