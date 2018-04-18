package br.edu.ufab.modelo.itens;
/**
 * Classe respons�vel por pegar os dados de trabalhos acad�micos. Esta classe herda da classe
 * Acervo, pois TrabalhoAcademico � um item que est� contido no acervo.
 * 
 * @author Murilo Gustavo e Taynar Sousa
 * */
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
