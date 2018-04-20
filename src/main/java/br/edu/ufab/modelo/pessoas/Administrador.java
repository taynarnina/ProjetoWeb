package br.edu.ufab.modelo.pessoas;

import java.sql.SQLException;

import br.edu.ufab.dao.CursoDao;
import br.edu.ufab.dao.itens.ItemDaoIF;
import br.edu.ufab.dao.pessoas.AdministradorDao;
import br.edu.ufab.dao.pessoas.AlunoDao;
import br.edu.ufab.dao.pessoas.FuncionarioDao;
import br.edu.ufab.modelo.Curso;
import br.edu.ufab.modelo.itens.ItemIF;


public class Administrador extends Funcionario{

	public boolean AdicionarItem(ItemIF item, ItemDaoIF itemDao) throws SQLException {
		return itemDao.adiciona(item);
	}
	
	public Object PesquisarItem(int id, ItemDaoIF itemDao) throws SQLException {
		return itemDao.pesquisa(id);
	}
	
	public boolean AlterarItem(ItemIF item, ItemDaoIF itemDao) throws SQLException {
		return itemDao.altera(item);
	}
	
	public boolean ExcluirItem(ItemIF item, ItemDaoIF itemDao) throws SQLException {
		return itemDao.remove(item);
	}
	
	public boolean ExcluirCurso(Curso curso, CursoDao cursodao) throws SQLException {
		return cursodao.remove(curso);
	}
	
	public boolean ExcluirAluno(Aluno aluno, AlunoDao alunodao) throws SQLException {
		return alunodao.remove(aluno);
	}
	
	public boolean AdicionarFuncionario(Funcionario funcionario, FuncionarioDao funcionariodao) throws SQLException {
		return funcionariodao.adiciona(funcionario);
	}
	
	public Funcionario PesquisarFuncionario(int id, FuncionarioDao funcionariodao) throws SQLException {
		return funcionariodao.pesquisa(id);
	}
	
	public boolean AlterarFuncionario(Funcionario funcionario, FuncionarioDao funcionariodao) throws SQLException {
		return funcionariodao.altera(funcionario);
	}
	
	public boolean ExcluirFuncionario(Funcionario funcionario, FuncionarioDao funcionariodao) throws SQLException {
		return funcionariodao.remove(funcionario);
	}
	
	public boolean AdicionarAdministardor(Administrador administardor, AdministradorDao administradordao) throws SQLException {
		return administradordao.adiciona(administardor);
	}
	
	public Administrador PesquisarAdministardor(int id, AdministradorDao administradordao) throws SQLException {
		return administradordao.pesquisa(id);
	}
	
	public boolean AlterarAdministardor(Administrador administardor, AdministradorDao administradordao) throws SQLException {
		return administradordao.altera(administardor);
	}
	
	public boolean ExcluirAdministador(Administrador administardor, AdministradorDao administradordao) throws SQLException {
		return administradordao.remove(administardor);
	}
}
