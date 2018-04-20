package br.edu.ufab.modelo.pessoas;

public class Aluno {
	private int id;
	private String matricula;
	private String cpf;
	private String rg;
	private String naturalidade;
	private String nome;
	private String nomedamae;
	private String endereco;
	private String telefone;
	private int curso;
	private int ano;
	private String periodo_ingresso;
	private String senha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomedamae() {
		return nomedamae;
	}
	public void setNomedamae(String nomedamae) {
		this.nomedamae = nomedamae;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}