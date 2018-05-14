package br.edu.ufab.model.entities.pessoas;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ufab.model.enums.NivelDeFuncionario;

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
