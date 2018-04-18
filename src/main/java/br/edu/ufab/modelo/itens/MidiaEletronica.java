package br.edu.ufab.modelo.itens;
/**
 * Classe responsável por pegar os dados de mídia. Esta classe herda da
 * classe Acervo, pois MidiaEletronica é um item do acervo da biblioteca.
 * 
 * @author Murilo Gustavo e Taynar Sousa
 * */
public class MidiaEletronica extends Acervo {
	private String tipo;
	private String data_gravacao;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getData_gravacao() {
		return data_gravacao;
	}
	public void setData_gravacao(String data_gravacao) {
		this.data_gravacao = data_gravacao;
	}
}
