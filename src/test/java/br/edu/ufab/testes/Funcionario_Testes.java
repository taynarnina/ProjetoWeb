package br.edu.ufab.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.edu.ufab.dao.CursoDao;
import br.edu.ufab.dao.pessoas.AlunoDao;
import br.edu.ufab.jdbc.ConnectionFactory;
import br.edu.ufab.modelo.Curso;
import br.edu.ufab.modelo.pessoas.Aluno;
import br.edu.ufab.modelo.pessoas.Funcionario;

public class Funcionario_Testes {

	static Connection connection;
	static Funcionario funcionario;
	
	@Before
	public void testaconexao() throws SQLException{
		connection = ConnectionFactory.getConnection();	
	}
	
	@Before
	public void instacia(){
		funcionario = new Funcionario();
	}
	
	@After
	public void fecharConexao() {
		try {
			if(!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void AdicionaCurso() throws SQLException {
		CursoDao cursodao = new CursoDao(connection);
		Curso curso = new Curso();
		curso.setNome("Musica");
		curso.setCodigo("MU");
		curso.setArea("Ciencias Humanas");
		curso.setTipo("G");
		
		assertTrue(funcionario.AdicionarCurso(curso,cursodao));
	}
	
	@Test
	public void PesquisaCurso() throws SQLException {
		CursoDao cursodao = new CursoDao(connection);
		Curso cursopesquisado = new Curso();
		
		cursopesquisado = funcionario.PesquisarCurso(28, cursodao);
		
		Curso cursoesperado = new Curso();
		cursoesperado.setId(28);
		cursoesperado.setNome("Letras-Ingles");
		cursoesperado.setCodigo("LI");
		cursoesperado.setArea("Ciencias Humanas");
		cursoesperado.setTipo("G");
		
		assertEquals(cursoesperado.getId(),cursopesquisado.getId());
		assertEquals(cursoesperado.getNome(),cursopesquisado.getNome());
		assertEquals(cursoesperado.getCodigo(),cursopesquisado.getCodigo());
		assertEquals(cursoesperado.getArea(),cursopesquisado.getArea());
		assertEquals(cursoesperado.getTipo(),cursopesquisado.getTipo());
	}
	
	@Test
	public void AlteraCurso() throws SQLException {
		Curso curso = new Curso();
		
		curso.setId(29);
		curso.setNome("Letras-Espanhol");
		curso.setCodigo("LE");
		curso.setArea("Ciencias Humanas");
		curso.setTipo("G");
		
		CursoDao cursodao = new CursoDao(connection);
		
		assertTrue(funcionario.AlterarCurso(curso, cursodao));
	}
	
	@Test
	public void AdicionaAluno() throws SQLException {
		AlunoDao alunodao = new AlunoDao(connection);
		Aluno aluno = new Aluno();
		aluno.setMatricula("GAD-141004");
		aluno.setCpf("09112345678");
		aluno.setRg("12345678");
		aluno.setNaturalidade("Pocinhos");
		aluno.setNome("Pedro da Silva");
		aluno.setNomedamae("Joana da Silva");
		aluno.setEndereco("Avenida do Campo");
		aluno.setTelefone("08399992222");
		aluno.setCurso(1); //referencia a tabela curso
		aluno.setAno(2014);
		aluno.setPeriodo_ingresso("1");
		aluno.setSenha("4321");
		
		assertTrue(funcionario.AdicionarAluno(aluno,alunodao));
	}
	
	@Test
	public void PesquisaAluno() throws SQLException {
		AlunoDao alunodao = new AlunoDao(connection);
		Aluno alunopesquisado = new Aluno();
		
		alunopesquisado = funcionario.PesquisarAluno(2, alunodao);
		
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
	
	@Test
	public void AlteraAluno() throws SQLException {
		Aluno aluno = new Aluno();
		
		aluno.setId(3);
		aluno.setMatricula("GAD-151002");
		aluno.setCpf("09112345678");
		aluno.setRg("12345678");
		aluno.setNaturalidade("Olivedos");
		aluno.setNome("Flavio dos Santos");
		aluno.setNomedamae("Maria dos Santos");
		aluno.setEndereco("Avenida do Cabo");
		aluno.setTelefone("08399792822");
		aluno.setCurso(1); //referencia a tabela curso
		aluno.setAno(2015);
		aluno.setPeriodo_ingresso("1");
		aluno.setSenha("4321");
		
		AlunoDao alunodao = new AlunoDao(connection);
		
		assertTrue(funcionario.AlterarAluno(aluno, alunodao));
	}
}
