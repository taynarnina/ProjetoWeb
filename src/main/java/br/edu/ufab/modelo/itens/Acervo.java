package br.edu.ufab.modelo.itens;
/**
 * Classe abstrata responsável por pegar o id e título de todos os itens do acervo
 *
 * @author Murilo Gustavo dos Santos
 */

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
