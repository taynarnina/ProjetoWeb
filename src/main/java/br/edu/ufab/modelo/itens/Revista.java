package br.edu.ufab.modelo.itens;
/**
 * Classe responsável por pegar os dados de revist. Esta classe herda da
 * classe Impressos, pois revista é um tipo de impresso e é um item de acervo.
 * 
 * @author Murilo Gustavo e Taynar Sousa
 * */
public class Revista extends Impressos{
	private String data_publicacao;

	public String getData_publicacao() {
		return data_publicacao;
	}
	public void setData_publicacao(String data_publicacao) {
		this.data_publicacao = data_publicacao;
	}
}
