package br.edu.ufab.modelo.pessoas;
/**
 * Classe responsável por recuperar a matricula, o nome da mãe, curso ano e o periodo do curso
 * 
 * 
 * @author Taynar Sousa e Murilo Gustavo
 * */
public class Aluno extends Pessoa{
	private String matricula;
	private String nomedamae;
	private int curso;
	private int ano;
	private String periodo_ingresso;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getNomedamae() {
		return nomedamae;
	}
	public void setNomedamae(String nomedamae) {
		this.nomedamae = nomedamae;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getPeriodo_ingresso() {
		return periodo_ingresso;
	}
	public void setPeriodo_ingresso(String periodo_ingresso) {
		this.periodo_ingresso = periodo_ingresso;
	}
}
