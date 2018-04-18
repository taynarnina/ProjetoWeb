package br.edu.ufab.modelo.itens;

import java.util.Date;

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
