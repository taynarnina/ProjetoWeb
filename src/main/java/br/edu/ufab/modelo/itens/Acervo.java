package br.edu.ufab.modelo.itens;
/**
 * Classe abstrata responsável por recuperar dados como o id e título do acervo.
 * 
 * @author Taynar Sousa e Murilo Gustavo
 * */
public abstract class Acervo implements ItemIF {
	private int id;
	private String titulo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
