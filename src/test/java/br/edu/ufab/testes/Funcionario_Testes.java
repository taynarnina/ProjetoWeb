package br.edu.ufab.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.ufab.dao.pessoas.FuncionarioDao;
import br.edu.ufab.jdbc.ConnectionFactory;
import br.edu.ufab.modelo.pessoas.Funcionario;

public class Funcionario_Testes {

	static Connection connection;
	
	@BeforeClass
	public static void testaconexao() throws SQLException{
		connection = ConnectionFactory.getConnection();	
	}
	
	@AfterClass
	public  static void fecharConexao() {
		try {
			if(!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void adicionaFuncionario() throws SQLException{
		FuncionarioDao fd = new FuncionarioDao(connection);
		Funcionario f = new Funcionario();
		
		f.setCpf("09215345678");
		f.setRg("14345578");
		f.setNome("Roberto Freire");
		f.setNaturalidade("Moca");
		f.setEndereco("Rua do Lobos");
		f.setTelefone("08399921222");
		f.setEmail("roberto@mail.com");
		f.setUsuario("Robe");
		f.setSenha("12345");
		
		assertTrue(fd.adiciona(f));
	}
	
	@Test
	public void alteraFuncionario() throws SQLException {
		Funcionario f = new Funcionario();
		
		f.setId(1);
		f.setCpf("09215345679");
		f.setRg("14345578");
		f.setNome("Roberto Freire");
		f.setNaturalidade("Soledade");
		f.setEndereco("Rua do Lobos");
		f.setTelefone("08399921222");
		f.setEmail("robertof@mail.com");
		f.setUsuario("RobeF");
		f.setSenha("12345");
		
		FuncionarioDao fd = new FuncionarioDao(connection);
		
		assertTrue(fd.altera(f));
	}
	
	@Test
	public void pesquisaFuncionario() throws SQLException {
		FuncionarioDao fd = new FuncionarioDao(connection);
		Funcionario funcionariopequisado = new Funcionario();
		
		funcionariopequisado = fd.pesquisa(1);
		
		Funcionario funcionarioesperado = new Funcionario();
		
		funcionarioesperado.setId(1);
		funcionarioesperado.setCpf("09215345679");
		funcionarioesperado.setRg("14345578");
		funcionarioesperado.setNome("Roberto Freire");
		funcionarioesperado.setNaturalidade("Soledade");
		funcionarioesperado.setEndereco("Rua do Lobos");
		funcionarioesperado.setTelefone("08399921222");
		funcionarioesperado.setEmail("robertof@mail.com");
		funcionarioesperado.setUsuario("RobeF");
		funcionarioesperado.setSenha("12345");
		
		assertEquals(funcionarioesperado.getId(),funcionariopequisado.getId());
		assertEquals(funcionarioesperado.getCpf(),funcionariopequisado.getCpf());
		assertEquals(funcionarioesperado.getRg(),funcionariopequisado.getRg());
		assertEquals(funcionarioesperado.getNome(),funcionariopequisado.getNome());
		assertEquals(funcionarioesperado.getNaturalidade(),funcionariopequisado.getNaturalidade());
		assertEquals(funcionarioesperado.getEndereco(),funcionariopequisado.getEndereco());
		assertEquals(funcionarioesperado.getTelefone(),funcionariopequisado.getTelefone());
		assertEquals(funcionarioesperado.getEmail(),funcionariopequisado.getEmail());
		assertEquals(funcionarioesperado.getUsuario(),funcionariopequisado.getUsuario());
		assertEquals(funcionarioesperado.getSenha(),funcionariopequisado.getSenha());
	}
	
	@Test
	public void removeFuncionario() throws SQLException {
		Funcionario f = new Funcionario();
		FuncionarioDao fd = new FuncionarioDao(connection);
		
		f = fd.pesquisa(3);
		
		assertTrue(fd.remove(f));
	}
}