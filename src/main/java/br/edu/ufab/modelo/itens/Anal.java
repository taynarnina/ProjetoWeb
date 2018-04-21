package br.edu.ufab.modelo.itens;

/**
 * Classe responsável por recuperar o nome do congresso e o ano de publicação do mesmo.
 * Essa classe herda dados de TrabalhoAcademico.
 * 
 * @author Taynar Sousa e Murilo Gustavo
 * */

public class Anal extends TrabalhoAcademico {
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
