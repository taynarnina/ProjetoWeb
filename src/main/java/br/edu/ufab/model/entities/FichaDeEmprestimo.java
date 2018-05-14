package br.edu.ufab.model.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.edu.ufab.model.entities.pessoas.Aluno;

@Entity
public class FichaDeEmprestimo {
	
	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne
	private Aluno aluno;
	
	@OneToMany
	private Set<ItemDeEmprestimo> emprestimos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Set<ItemDeEmprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(Set<ItemDeEmprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
}
