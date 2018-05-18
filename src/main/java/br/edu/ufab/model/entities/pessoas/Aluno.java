package br.edu.ufab.model.entities.pessoas;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ufab.model.entities.Curso;
import br.edu.ufab.model.enums.PeriodoDeIngresso;

@Entity
public class Aluno extends Pessoa {

	private String matricula;
	
	@NotNull
	@NotEmpty
	private String nomemae;
	
	@ManyToOne
	private Curso curso;
	
	@NotNull
	private int ano;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private PeriodoDeIngresso periodo;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomemae() {
		return nomemae;
	}

	public void setNomemae(String nomemae) {
		this.nomemae = nomemae;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public PeriodoDeIngresso getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PeriodoDeIngresso periodo) {
		this.periodo = periodo;
	}
}
