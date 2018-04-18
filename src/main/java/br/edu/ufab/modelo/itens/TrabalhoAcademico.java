package br.edu.ufab.modelo.itens;
/**
 * Classe respons�vel por pegar os dados dos trabalhos acad�micos.
 * Essa classe herda objetos da classe Acervo, pos trabalho acad�mico � um item de acervo.
 *
 * @author Murilo Gustavo e Taynar Sousa
 */
public abstract class TrabalhoAcademico extends Acervo {
	private String tipo;
	private String autores;
	private String local;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
}
