package br.edu.ufab.modelo.itens;

import java.util.Date;
/**
 * Classe respons�vel por pegar o tipo de mj�dia e a data de grava��o.
 * Essa classe herda objetos da classe Acervo, pois Midia � um item de acervo.
 *
 * @author Murilo Gustavo e Taynar Sousa
 */
public class MidiaEletronica extends Acervo {
	private String tipo;
	private Date data_gravacao;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getData_gravacao() {
		return data_gravacao;
	}
	public void setData_gravacao(Date data_gravacao) {
		this.data_gravacao = data_gravacao;
	}
}
