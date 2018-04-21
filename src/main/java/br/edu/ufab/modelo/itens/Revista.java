package br.edu.ufab.modelo.itens;
/**
 * Classe respons�vel por recuperar a data de publica��o de uma revista.
 * Essa classe herda dados de Impressos.
 * 
 * @author Taynar Sousa e Murilo Gustavo
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
