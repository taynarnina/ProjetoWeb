package br.edu.ufab.modelo.itens;

public class TCC extends TrabalhoAcademico{
	private String orientador;
	private int ano_defesa;
	
	public String getOrientador() {
		return orientador;
	}
	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}
	public int getAno_defesa() {
		return ano_defesa;
	}
	public void setAno_defesa(int ano_defesa) {
		this.ano_defesa = ano_defesa;
	}
}
