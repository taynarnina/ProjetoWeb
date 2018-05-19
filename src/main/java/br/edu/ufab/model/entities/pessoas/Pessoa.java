package br.edu.ufab.model.entities.pessoas;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * Classe abstrata que pega todos os dados da Pessoa.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@NotEmpty
	private String cpf;
	
	@NotNull
	@NotEmpty
	private String rg;
	
	@NotNull
	@NotEmpty
	private String nome;
	
	@NotNull
	@NotEmpty
	private String naturalidade;
	
	@NotNull
	@NotEmpty
	private String endereco;
	
	@NotNull
	@NotEmpty
	private String telefone;
	
	@NotNull
	@NotEmpty
	private String datanascimento;
	
	@NotNull
	@NotEmpty
	private String senha;
	
	@NotNull
	@NotEmpty
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
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

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
