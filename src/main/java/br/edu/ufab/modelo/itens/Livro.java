package br.edu.ufab.modelo.itens;
/**
 * Classe responsável por pegar os dados de livro. Esta classe herda 
 * da classe Impressos, pois livro é um item de acervo que é impresso.
 * 
 * @author Murilo Gustavo e Taynar Sousa
 * */
public class Livro extends Impressos{
	private String ISBN;
	private String autores;
	private int ano_publicacao;
	private String area;
	private String tema;
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public int getAno_publicacao() {
		return ano_publicacao;
	}
	public void setAno_publicacao(int ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
}
