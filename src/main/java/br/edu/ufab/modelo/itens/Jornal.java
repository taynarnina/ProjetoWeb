package br.edu.ufab.modelo.itens;
/**
 * Classe responsável por pegar os dados de Jornal. Esta classe herda da
 * classe Impressos, pois anal é um item de acervo do tipo impresso.
 * 
 * @author Murilo Gustavo e Taynar Sousa
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
