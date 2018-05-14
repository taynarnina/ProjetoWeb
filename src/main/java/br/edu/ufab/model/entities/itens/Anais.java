package br.edu.ufab.model.entities.itens;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ufab.model.enums.TipoDeAnais;

@Entity
public class Anais extends TrabalhoAcademico {
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDeAnais tipo;

	@NotNull
	@NotEmpty
	private String nomecongreco;

	public TipoDeAnais getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeAnais tipo) {
		this.tipo = tipo;
	}

	public String getNomecongreco() {
		return nomecongreco;
	}

	public void setNomecongreco(String nomecongreco) {
		this.nomecongreco = nomecongreco;
	}
}
