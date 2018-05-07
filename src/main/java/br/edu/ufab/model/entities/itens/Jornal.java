package br.edu.ufab.model.entities.itens;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Jornal extends Impresso {

	@NotNull
	@NotEmpty
	private String data;
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
