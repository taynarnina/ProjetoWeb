package br.edu.ufab.modelo.pessoas;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ufab.dao.CursoDao;
import br.edu.ufab.dao.pessoas.AlunoDao;
import br.edu.ufab.modelo.Curso;

public class Funcionario extends Pessoa{
	private String email;
	private String usuario;
	Connection connection;
	
	public boolean AdicionarCurso(Curso curso, CursoDao cursodao) throws SQLException {
		return cursodao.adiciona(curso);
	}
	
	public Curso PesquisarCurso(int id, CursoDao cursodao) throws SQLException {
		return cursodao.pesquisa(id);
	}
	
	public boolean AlterarCurso(Curso curso, CursoDao cursodao) throws SQLException {
		return cursodao.altera(curso);
	}
	
	public boolean AdicionarAluno(Aluno aluno, AlunoDao alunodao) throws SQLException {
		return alunodao.adiciona(aluno);
	}
	
	public Aluno PesquisarAluno(int id, AlunoDao alunodao) throws SQLException {
		return alunodao.pesquisa(id);
	}
	
	public boolean AlterarAluno(Aluno aluno, AlunoDao alunodao) throws SQLException {
		return alunodao.altera(aluno);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
