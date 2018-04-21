package br.edu.ufab.modelo.itens;

/**
 * Classe responsável por recuperar a data de publicação do jornal.
 * Essa classe herda dados de Impressos.
 * 
 * @author Taynar Sousa e Murilo Gustavo
 * */

public class Jornal extends Impressos{
	private String data;

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
