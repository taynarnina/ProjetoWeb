package br.edu.ufab.model.entities.itens;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ufab.model.entities.Autor;

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
