package br.edu.ufab.model.entities.itens;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ufab.model.entities.Autor;

/**
 * Classe que representa uma view dos dados de livro. Como estamos
 * usando hibernate, a classe Livro é uma entidade e  seus atributos serão os campos
 * que serão gerados, conforme mostramos abaixo,
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */

@Entity
public class Livro extends Impresso {

	@NotNull
	@NotEmpty
	private String isbn;
	
	@ManyToMany
	private Set<Autor> autores;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> atores) {
		this.autores = atores;
	}
}
