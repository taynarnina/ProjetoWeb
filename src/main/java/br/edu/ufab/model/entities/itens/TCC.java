package br.edu.ufab.model.entities.itens;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import br.edu.ufab.model.entities.Orientador;
import br.edu.ufab.model.enums.TipoDeTCC;

@Entity
public class TCC extends TrabalhoAcademico {

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDeTCC tipo;
	
	@ManyToMany
	private Set<Orientador> orientadores;

	public TipoDeTCC getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeTCC tipo) {
		this.tipo = tipo;
	}

	public Set<Orientador> getOrientadores() {
		return orientadores;
	}

	public void setOrientadores(Set<Orientador> orientadores) {
		this.orientadores = orientadores;
	}
}
