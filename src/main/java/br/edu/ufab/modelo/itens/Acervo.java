package br.edu.ufab.modelo.itens;
/**
 * Classe abstrata responsável por gerar os dados de acervo.
 * @author Murilo Gustavo e Taynar Sousa
 * */
public abstract class Acervo {
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
