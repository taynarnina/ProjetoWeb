package br.edu.ufab.modelo.itens;
/**
 * Classe responsável por pegar os dados de anal. Esta classe herda de
 * TrabalhoAcademico, pois anal é um tipo de trabalho acadêmico.
 * 
 * @author Murilo Gustavo e Taynar Sousa
 * */
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
