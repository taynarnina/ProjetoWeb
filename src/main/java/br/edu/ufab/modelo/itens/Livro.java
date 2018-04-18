package br.edu.ufab.modelo.itens;
/**
 * Classe responsável por pegar os dados de impressos.
 * Essa classe herda objetos da classe Acervo.
 *
 * @author Murilo Gustavo e Taynar Sousa
 */
public class Livro extends Impressos{
	private String ISBN;
	private String autores;
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
