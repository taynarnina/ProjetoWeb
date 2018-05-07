package br.edu.ufab.model.entities.itens;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Revista extends Impresso {

	@NotNull
	@NotEmpty
	private String datapublicacao;

	public String getDatapublicacao() {
		return datapublicacao;
	}

	public void setDatapublicacao(String datapublicacao) {
		this.datapublicacao = datapublicacao;
	}
}
