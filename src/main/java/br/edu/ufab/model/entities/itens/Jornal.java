package br.edu.ufab.model.entities.itens;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Classe que representa uma view dos dados de jornal. Como estamos
 * usando hibernate, a classe Jornal é uma entidade e  seus atributos serão os campos
 * que serão gerados, conforme mostramos abaixo,
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */

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
