package br.edu.ufab.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ufab.model.entities.itens.Anais;
import br.edu.ufab.model.entities.itens.Jornal;
import br.edu.ufab.model.entities.itens.Livro;
import br.edu.ufab.model.entities.itens.MidiaEletronica;
import br.edu.ufab.model.entities.itens.Revista;
import br.edu.ufab.model.entities.itens.TCC;
import br.edu.ufab.model.entities.pessoas.Aluno;
/**
 * Classe que representa uma view dos dados de autor. Como estamos
 * usando hibernate, a classe Emprestimo é uma entidade e  seus atributos serão os campos
 * que serão gerados, conforme mostramos abaixo,
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Anais anais;
	
	@ManyToOne
	private Jornal jornal;
	
	@ManyToOne
	private MidiaEletronica midia;
	
	@ManyToOne
	private Livro livro;
	
	@ManyToOne
	private Revista revista;
	
	@ManyToOne
	private TCC tcc;
	
	@NotNull
	@NotEmpty
	private String dataemprestimo;
	
	@NotNull
	@NotEmpty
	private String datadevolucao;

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

	public Anais getAnais() {
		return anais;
	}

	public void setAnais(Anais anais) {
		this.anais = anais;
	}

	public Jornal getJornal() {
		return jornal;
	}

	public void setJornal(Jornal jornal) {
		this.jornal = jornal;
	}

	public MidiaEletronica getMidia() {
		return midia;
	}

	public void setMidia(MidiaEletronica midia) {
		this.midia = midia;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}

	public TCC getTcc() {
		return tcc;
	}

	public void setTcc(TCC tcc) {
		this.tcc = tcc;
	}

	public String getDataemprestimo() {
		return dataemprestimo;
	}

	public void setDataemprestimo(String dataemprestimo) {
		this.dataemprestimo = dataemprestimo;
	}

	public String getDatadevolucao() {
		return datadevolucao;
	}

	public void setDatadevolucao(String datadevolucao) {
		this.datadevolucao = datadevolucao;
	}
}
