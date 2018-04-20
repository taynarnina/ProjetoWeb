package br.edu.ufab.modelo.itens;

public class Jornal extends Impressos implements ItemIF{
	private String data;

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
