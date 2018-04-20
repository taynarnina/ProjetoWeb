package br.edu.ufab.testes;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.ufab.dao.CursoDao;
import br.edu.ufab.jdbc.ConnectionFactory;
import br.edu.ufab.modelo.Curso;

public class Curso_Testes {
	
	static Connection connection;
	
	@BeforeClass
	public static void testaconexao() throws SQLException{
		connection = ConnectionFactory.getConnection();	
	}
	
	@AfterClass
	public  static void fecharConexao() {
		try {
			if(!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void adicionaCurso() throws SQLException {
		CursoDao cd = new CursoDao(connection);
		Curso c = new Curso();
		
		c.setNome("Letras");
		c.setCodigo("LI");
		c.setArea("Ciencias Humanas");
		c.setTipo("G");
		
		assertTrue(cd.adiciona(c));
	}
	
	@Test
	public void alteraCurso() throws SQLException {
		Curso c = new Curso();
		
		c.setId(28);
		c.setNome("LetrasIngles");
		c.setCodigo("LI");
		c.setArea("Ciencias Humanas");
		c.setTipo("G");
		
		CursoDao cd = new CursoDao(connection);
		
		assertTrue(cd.altera(c));
	}
	
	@Test
	public void pesquisaCurso() throws SQLException {
		CursoDao cd = new CursoDao(connection);
		Curso cursopesquisado = new Curso();
		
		cursopesquisado = cd.pesquisa(28);
		
		Curso cursoesperado = new Curso();
		cursoesperado.setId(28);
		cursoesperado.setNome("LetrasIngles");
		cursoesperado.setCodigo("LI");
		cursoesperado.setArea("Ciencias Humanas");
		cursoesperado.setTipo("G");
		
		assertEquals(cursoesperado.getId(),cursopesquisado.getId());
		assertEquals(cursoesperado.getNome(),cursopesquisado.getNome());
		assertEquals(cursoesperado.getCodigo(),cursopesquisado.getCodigo());
		assertEquals(cursoesperado.getArea(),cursopesquisado.getArea());
		assertEquals(cursoesperado.getTipo(),cursopesquisado.getTipo());
	}

}