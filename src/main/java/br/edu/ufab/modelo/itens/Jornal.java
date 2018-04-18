package br.edu.ufab.modelo.itens;

import java.util.Date;
/**
 * Classe responsável por pegar a data de publicação do jornal.
 * Essa classe herda objetos da classe Impressos, pois jornal é um tipo de impresso e é um item de Acervo.
 *  
 *
 * @author Murilo Gustavo e Taynar Sousa
 */
public class Jornal extends Impressos{
	private Date data;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
