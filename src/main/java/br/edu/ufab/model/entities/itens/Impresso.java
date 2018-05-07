package br.edu.ufab.model.entities.itens;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Impresso extends ItemAcervo {

	@NotNull
	@NotEmpty
	private String edicao;
	
	@NotNull
	@NotEmpty
	private String editora;
	
	@NotNull
	private int numpaginas;


	public String getEdicao() {
		return edicao;
	}


	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}


	public String getEditora() {
		return editora;
	}


	public void setEditora(String editora) {
		this.editora = editora;
	}


	public int getNumpaginas() {
		return numpaginas;
	}


	public void setNumpaginas(int numpaginas) {
		this.numpaginas = numpaginas;
	}
}
