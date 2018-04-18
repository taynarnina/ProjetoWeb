package br.edu.ufab.testes;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.ufab.dao.pessoas.AlunoDao;
import br.edu.ufab.jdbc.ConnectionFactory;
import br.edu.ufab.modelo.pessoas.Aluno;

public class Aluno_Testes {
	
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
	public void adicionaAluno() throws SQLException{
		AlunoDao ad = new AlunoDao(connection);
		Aluno a = new Aluno();
		
		a.setMatricula("GAD-142002");
		a.setCpf("09112345678");
		a.setRg("12345678");
		a.setNaturalidade("Pocinhos");
		a.setNome("João da Silva");
		a.setNomedamae("Joana da Silva");
		a.setEndereco("Avenida do Campo");
		a.setTelefone("08399992222");
		a.setCurso(1); //referencia a tabela curso
		a.setAno(2014);
		a.setPeriodo_ingresso("2");
		a.setSenha("4321");
		
		assertTrue(ad.adiciona(a));
	}
	
	@Test
	public void alteraAluno() throws SQLException{
		Aluno a = new Aluno();
		
		a.setId(3);
		a.setMatricula("GAD-141002");
		a.setCpf("09112345678");
		a.setRg("12345678");
		a.setNaturalidade("Olivedos");
		a.setNome("João dos Santos");
		a.setNomedamae("Joana dos Santos");
		a.setEndereco("Avenida do Campo");
		a.setTelefone("08399992222");
		a.setCurso(1); //referencia a tabela curso
		a.setAno(2014);
		a.setPeriodo_ingresso("1");
		a.setSenha("4321");
		
		AlunoDao ad = new AlunoDao(connection);
		
		assertTrue(ad.altera(a));
	}
	
	@Test
	public void pesquisaAluno() throws SQLException {
		AlunoDao ad = new AlunoDao(connection);
		Aluno alunopesquisado = new Aluno();
		
		alunopesquisado = ad.pesquisa(2);
		
		Aluno alunoesperado = new Aluno();
		
		alunoesperado.setId(2);
		alunoesperado.setMatricula("GAD-141002");
		alunoesperado.setCpf("09112345678");
		alunoesperado.setRg("12345678");
		alunoesperado.setNaturalidade("Olivedos");
		alunoesperado.setNome("João dos Santos");
		alunoesperado.setNomedamae("Joana dos Santos");
		alunoesperado.setEndereco("Avenida do Campo");
		alunoesperado.setTelefone("08399992222");
		alunoesperado.setCurso(1); //referencia a tabela curso
		alunoesperado.setAno(2014);
		alunoesperado.setPeriodo_ingresso("1");
		alunoesperado.setSenha("4321");
		
		assertEquals(alunoesperado.getId(),alunopesquisado.getId());
		assertEquals(alunoesperado.getMatricula(),alunopesquisado.getMatricula());
		assertEquals(alunoesperado.getCpf(),alunopesquisado.getCpf());
		assertEquals(alunoesperado.getRg(),alunopesquisado.getRg());
		assertEquals(alunoesperado.getNaturalidade(),alunopesquisado.getNaturalidade());
		assertEquals(alunoesperado.getNome(),alunopesquisado.getNome());
		assertEquals(alunoesperado.getNomedamae(),alunopesquisado.getNomedamae());
		assertEquals(alunoesperado.getEndereco(),alunopesquisado.getEndereco());
		assertEquals(alunoesperado.getTelefone(),alunopesquisado.getTelefone());
		assertEquals(alunoesperado.getCurso(),alunopesquisado.getCurso());
		assertEquals(alunoesperado.getAno(),alunopesquisado.getAno());
		assertEquals(alunoesperado.getPeriodo_ingresso(),alunopesquisado.getPeriodo_ingresso());
		assertEquals(alunoesperado.getSenha(),alunopesquisado.getSenha());
		
	}
}
