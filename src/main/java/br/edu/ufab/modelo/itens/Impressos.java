package br.edu.ufab.modelo.itens;

public abstract class Impressos extends Acervo {
	private String edicao;
	private String editora;
	private int numero_paginas;
	
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String edtora) {
		this.editora = edtora;
	}
	public int getNumero_paginas() {
		return numero_paginas;
	}
	public void setNumero_paginas(int numero_paginas) {
		this.numero_paginas = numero_paginas;
	}
}