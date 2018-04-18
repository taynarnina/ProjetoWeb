package br.edu.ufab.modelo.itens;
/**
 * Classe respons�vel por pegar os dados de Tcc. Esta classe herda da classe
 * TrabalhoAcademico, pois tcc � um tipo de trabalho acad�mico e � um item do acervo.
 * 
 * @author Murilo Gustavo e Taynar Sousa
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
