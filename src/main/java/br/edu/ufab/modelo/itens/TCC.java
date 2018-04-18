package br.edu.ufab.modelo.itens;
/**
 * Classe responsável por pegar os dados de Tcc.
 *
 * @author Murilo Gustavo e Taynar Sousa
 */
public class TCC {
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
