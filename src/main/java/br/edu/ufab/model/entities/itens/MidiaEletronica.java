package br.edu.ufab.model.entities.itens;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ufab.model.enums.TipoDeMidia;

/**
 * Classe que representa uma view dos dados de midia. Como estamos
 * usando hibernate, a classe MidiaEletronica é uma entidade e  seus atributos serão os campos
 * que serão gerados, conforme mostramos abaixo,
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */

@Entity
public class MidiaEletronica extends ItemAcervo {

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDeMidia tipo;
	
	@NotNull
	@NotEmpty
	private String data;

	public TipoDeMidia getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeMidia tipo) {
		this.tipo = tipo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
