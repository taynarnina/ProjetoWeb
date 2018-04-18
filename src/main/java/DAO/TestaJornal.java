package DAO;

import java.sql.SQLException;

import biblio.Jornal;
import ufab.Cursos;
import ufab.Funcionario;

public class TestaJornal {
	
	
	public static void main(String[] args) throws SQLException  {
		Funcionario f1 = new Funcionario();
		Funcionario f2 = new Funcionario();
		FuncionarioDao jd = new FuncionarioDao();
		Cursos c = new Cursos();
		CursosDao cd = new CursosDao();
		
		f1.setCpf("123.456.789-00");
		f1.setRg("1.234.567");
		f1.setNome("Joao silva");
		f1.setEmail("joao@gmail");
		f1.setNaturalidade("campinas");
		f1.setNivel("A");
		f1.setTelefone("1234-5678");
		f1.setUsuario("joao");
		f1.setSenha("123456");
		
		jd.criar(f1);
		
		f2.setCpf("123.456.789-00");
		f2.setRg("1.234.567");
		f2.setNome("Maria silva");
		f2.setEmail("maria@gmail");
		f2.setNaturalidade("sao paulo");
		f2.setNivel("A");
		f2.setTelefone("1234-5678");
		f2.setUsuario("joao");
		f2.setSenha("123456");
		
		//jd.criar(f2);
		
		c.setNome("computação");
		c.setArea("ciencias exatas");
		c.setTipo("G");
		
		cd.criar(c);
		cd.excluir("computacao", f1);
		
	}
	

}
