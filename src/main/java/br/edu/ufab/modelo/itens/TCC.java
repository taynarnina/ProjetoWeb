package br.edu.ufab.modelo.itens;

/**
 * Classe responsável por recuperar o orientador e o ano de defesa de um tcc.
 * 
 * Essa classe herda dados de TrabalhoAcademico.
 * 
 * @author Taynar Sousa e Murilo Gustavo
 * */

public class TCC extends TrabalhoAcademico{
	private String orientador;
	private int ano_defesa;
	
	public String getOrientador() {
		return orientador;
	}
	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}
	public int getAno_defesa() {
		return ano_defesa;
	}
	public void setAno_defesa(int ano_defesa) {
		this.ano_defesa = ano_defesa;
	}
}
