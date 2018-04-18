package br.edu.ufab.modelo.itens;

import java.util.Date;
/**
 * Classe responsável por pegar o tipo de mjídia e a data de gravação.
 * Essa classe herda objetos da classe Acervo, pois Midia é um item de acervo.
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
