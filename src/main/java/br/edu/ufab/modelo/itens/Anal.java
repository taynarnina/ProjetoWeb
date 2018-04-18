package br.edu.ufab.modelo.itens;
/**
 * Classe respons�vel por pegar dados de Anuais.
 * Essa classe herda de trabalho acad�mico, pois anuais d�o tipos de trabalhos academicos, 
 * e trabalhos academicos s�o itens que fazem parte do acervo.
 *
 * @author Murilo Gustavo dos Santos e Taynar Sousa
 */

public class Anal extends TrabalhoAcademico{
	private String nome_congresso;
	private int ano_publicacao;
	
	public String getNome_congresso() {
		return nome_congresso;
	}
	public void setNome_congresso(String nome_congresso) {
		this.nome_congresso = nome_congresso;
	}
	public int getAno_publicacao() {
		return ano_publicacao;
	}
	public void setAno_publicacao(int ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}
}
