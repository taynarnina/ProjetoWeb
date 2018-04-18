package br.edu.ufab.modelo.itens;

import java.util.Date;

/**
 * Classe responsável por pegar a data de publicação da revista.
 * Essa classe herda objetos da classe Impressos, pois é um tipo de item do acervo que é impresso.
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
