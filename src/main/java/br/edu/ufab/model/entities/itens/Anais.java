package br.edu.ufab.model.entities.itens;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ufab.model.enums.TipoDeAnais;
/**
 * Classe que representa uma view dos dados de anais. Como estamos
 * usando hibernate, a classe Anais é uma entidade e  seus atributos serão os campos
 * que serão gerados, conforme mostramos abaixo,
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
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
