package br.edu.ufab.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.ufab.model.entities.itens.Anais;
import br.edu.ufab.model.entities.itens.Jornal;
import br.edu.ufab.model.entities.itens.Livro;
import br.edu.ufab.model.entities.itens.MidiaEletronica;
import br.edu.ufab.model.entities.itens.Revista;
import br.edu.ufab.model.entities.itens.TCC;

@Entity
public class ItemDeEmprestimo {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Anais anais;
	
	@ManyToOne
	private Jornal jornal;
	
	@ManyToOne
	private Livro livro;
	
	@ManyToOne
	private MidiaEletronica midia;
	
	@ManyToOne
	private Revista revista;
	
	@ManyToOne
	private TCC tcc;
	
	@Temporal(TemporalType.DATE)
	private Date dataemprestimo;
	
	@Temporal(TemporalType.DATE)
	private Date datadevolucao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Anais getAnais() {
		return anais;
	}

	public void setAnais(Anais anais) {
		this.anais = anais;
	}

	public Jornal getJornal() {
		return jornal;
	}

	public void setJornal(Jornal jornal) {
		this.jornal = jornal;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public MidiaEletronica getMidia() {
		return midia;
	}

	public void setMidia(MidiaEletronica midia) {
		this.midia = midia;
	}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}

	public TCC getTcc() {
		return tcc;
	}

	public void setTcc(TCC tcc) {
		this.tcc = tcc;
	}

	public Date getDataemprestimo() {
		return dataemprestimo;
	}

	public void setDataemprestimo(Date dataemprestimo) {
		this.dataemprestimo = dataemprestimo;
	}

	public Date getDatadevolucao() {
		return datadevolucao;
	}

	public void setDatadevolucao(Date datadevolucao) {
		this.datadevolucao = datadevolucao;
	}
}
