package br.edu.ufab.model.entities.pessoas;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ufab.model.enums.NivelDeFuncionario;
/**
 * Classe que representa uma view dos dados de funcionario. Como estamos
 * usando hibernate, a classe funcionario é uma entidade e  seus atributos serão os campos
 * que serão gerados, conforme mostramos abaixo,
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
@Entity
public class Funcionario extends Pessoa {

	@NotNull
	@NotEmpty
	private String usuario;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private NivelDeFuncionario nivel;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public NivelDeFuncionario getNivel() {
		return nivel;
	}

	public void setNivel(NivelDeFuncionario nivel) {
		this.nivel = nivel;
	}
}
