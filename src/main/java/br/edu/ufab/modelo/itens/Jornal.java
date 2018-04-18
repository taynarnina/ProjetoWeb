package br.edu.ufab.modelo.itens;

import java.util.Date;
/**
 * Classe respons�vel por pegar a data de publica��o do jornal.
 * Essa classe herda objetos da classe Impressos, pois jornal � um tipo de impresso e � um item de Acervo.
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
