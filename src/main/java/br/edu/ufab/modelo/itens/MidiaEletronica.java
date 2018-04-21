package br.edu.ufab.modelo.itens;
/**
 * Classe responsável por recuperar o tipo e data de gravação da midia.
 * Essa classe herda dados de Acervo.
 * 
 * @author Taynar Sousa e Murilo Gustavo
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
