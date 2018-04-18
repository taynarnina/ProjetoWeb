package br.edu.ufab.modelo.itens;

import java.util.Date;

/**
 * Classe respons�vel por pegar a data de publica��o da revista.
 * Essa classe herda objetos da classe Impressos, pois � um tipo de item do acervo que � impresso.
 *
 * @author Murilo Gustavo e Taynar Sousa
 */
public class Revista extends Impressos{
	private Date data_publicacao;

	public Date getData_publicacao() {
		return data_publicacao;
	}

	public void setData_publicacao(Date data_publicacao) {
		this.data_publicacao = data_publicacao;
	}
}
