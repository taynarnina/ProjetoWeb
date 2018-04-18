package br.edu.ufab.modelo.itens;

import java.util.Date;

public class Revista extends Impressos{
	private Date data_publicacao;

	public Date getData_publicacao() {
		return data_publicacao;
	}

	public void setData_publicacao(Date data_publicacao) {
		this.data_publicacao = data_publicacao;
	}
}
