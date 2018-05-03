package br.edu.ufab.model.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ufab.model.enums.AreaDeCurso;
import br.edu.ufab.model.enums.TipoDeCurso;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@NotEmpty
	private String nome;
	
	@NotNull
	@NotEmpty
	private String codigo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private AreaDeCurso area;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDeCurso tipo;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public AreaDeCurso getArea() {
		return area;
	}

	public void setArea(AreaDeCurso area) {
		this.area = area;
	}

	public TipoDeCurso getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeCurso tipo) {
		this.tipo = tipo;
	}
}
