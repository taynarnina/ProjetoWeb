package br.edu.ufab.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.edu.ufab.dao.itens.AnalDao;
import br.edu.ufab.dao.itens.JornalDao;
import br.edu.ufab.dao.itens.LivroDao;
import br.edu.ufab.dao.itens.MidiaEletronicaDao;
import br.edu.ufab.dao.itens.RevistaDao;
import br.edu.ufab.dao.itens.TCCDao;
import br.edu.ufab.dao.pessoas.AdministradorDao;
import br.edu.ufab.dao.pessoas.FuncionarioDao;
import br.edu.ufab.jdbc.ConnectionFactory;
import br.edu.ufab.modelo.itens.Anal;
import br.edu.ufab.modelo.itens.Jornal;
import br.edu.ufab.modelo.itens.Livro;
import br.edu.ufab.modelo.itens.MidiaEletronica;
import br.edu.ufab.modelo.itens.Revista;
import br.edu.ufab.modelo.itens.TCC;
import br.edu.ufab.modelo.pessoas.Administrador;
import br.edu.ufab.modelo.pessoas.Funcionario;

public class Administrador_Testes {

	static Connection connection;
	static Administrador administrador;
	
	@Before
	public void testaconexao() throws SQLException{
		connection = ConnectionFactory.getConnection();	
	}
	
	@Before
	public void instacia(){
		administrador = new Administrador();
	}
	
	@After
	public void fecharConexao() {
		try {
			if(!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void AdcionaLivro() throws SQLException {
		Livro livro =  new Livro();
		LivroDao livrodao = new LivroDao(connection);
		
		livro.setTitulo("Engenharia de Software");
		livro.setEdicao("2º Edição");
		livro.setEditora("Nova Era");
		livro.setNumero_paginas(255);
		livro.setISBN("345678912");
		livro.setAutores("Freire, João Paulo");
		livro.setAno_publicacao(2010);
		livro.setArea("Computacao");
		livro.setTema("Engenharia de Software");
		
		assertTrue(administrador.AdicionarItem(livro, livrodao));
	}
	
	@Test
	public void PesquisaLivro() throws SQLException {
		LivroDao livrodao = new LivroDao(connection);
		Livro livropesquisado = new Livro();
		
		livropesquisado = (Livro) administrador.PesquisarItem(1, livrodao);
		
		Livro livroesperado =  new Livro();
		livroesperado.setId(1);
		livroesperado.setTitulo("Engenharia de Software");
		livroesperado.setEdicao("2º Edição");
		livroesperado.setEditora("Nova Era");
		livroesperado.setNumero_paginas(255);
		livroesperado.setISBN("345678911");
		livroesperado.setAutores("Freire, João Paulo");
		livroesperado.setAno_publicacao(2010);
		livroesperado.setArea("Computacao");
		livroesperado.setTema("Engenharia de Software");
		
		assertEquals(livroesperado.getId(),livropesquisado.getId());
		assertEquals(livroesperado.getTitulo(),livropesquisado.getTitulo());
		assertEquals(livroesperado.getEdicao(),livropesquisado.getEdicao());
		assertEquals(livroesperado.getEditora(),livropesquisado.getEditora());
		assertEquals(livroesperado.getNumero_paginas(),livropesquisado.getNumero_paginas());
		assertEquals(livroesperado.getISBN(),livropesquisado.getISBN());
		assertEquals(livroesperado.getAutores(),livropesquisado.getAutores());
		assertEquals(livroesperado.getAno_publicacao(),livropesquisado.getAno_publicacao());
		assertEquals(livroesperado.getArea(),livropesquisado.getArea());
		assertEquals(livroesperado.getTema(),livropesquisado.getTema());
	}
	
	@Test
	public void AlteraLivro() throws SQLException {
		Livro livro =  new Livro();
		
		livro.setId(2);
		livro.setTitulo("Engenharia de Software 3.0");
		livro.setEdicao("2º Edição");
		livro.setEditora("Nova Era");
		livro.setNumero_paginas(255);
		livro.setISBN("345678913");
		livro.setAutores("Freire, João Paulo");
		livro.setAno_publicacao(2012);
		livro.setArea("Computacao");
		livro.setTema("Engenharia de Software");
		
		LivroDao livrodao = new LivroDao(connection);
		
		assertTrue(administrador.AlterarItem(livro, livrodao));
	}
	
	@Test
	public void RemoveLivro() throws SQLException {
		
	}
	
	@Test
	public void AdcionaRevista() throws SQLException {
		Revista revista =  new Revista();
		RevistaDao revistadao = new RevistaDao(connection);
		
		revista.setTitulo("TV Escola");
		revista.setEdicao("12º Edição");
		revista.setEditora("Abril");
		revista.setNumero_paginas(25);
		revista.setData_publicacao("2016-12-04");
		
		assertTrue(administrador.AdicionarItem(revista, revistadao));
	}
	
	@Test
	public void PesquisaRevista() throws SQLException {
		RevistaDao revistadao = new RevistaDao(connection);
		Revista revistapesquisada = new Revista();
		
		revistapesquisada = (Revista) administrador.PesquisarItem(1, revistadao);
		
		Revista revistaesperada =  new Revista();
		revistaesperada.setId(1);
		revistaesperada.setTitulo("TV Escola");
		revistaesperada.setEdicao("12º Edição");
		revistaesperada.setEditora("Março");
		revistaesperada.setNumero_paginas(25);
		revistaesperada.setData_publicacao("2016-12-04");
		
		assertEquals(revistaesperada.getId(),revistapesquisada.getId());
		assertEquals(revistaesperada.getTitulo(),revistapesquisada.getTitulo());
		assertEquals(revistaesperada.getEdicao(),revistapesquisada.getEdicao());
		assertEquals(revistaesperada.getEditora(),revistapesquisada.getEditora());
		assertEquals(revistaesperada.getNumero_paginas(),revistapesquisada.getNumero_paginas());
		assertEquals(revistaesperada.getData_publicacao(),revistapesquisada.getData_publicacao());
	}
	
	@Test
	public void AlteraRevista() throws SQLException {
		Revista revista =  new Revista();
		
		revista.setId(2);
		revista.setTitulo("TV Nova Escola");
		revista.setEdicao("12º Edição");
		revista.setEditora("Dezembro");
		revista.setNumero_paginas(25);
		revista.setData_publicacao("2016-12-04");
		
		RevistaDao revistadao = new RevistaDao(connection);
		
		assertTrue(administrador.AlterarItem(revista, revistadao));
	}
	
	@Test
	public void RemoveRevista() throws SQLException {
		
	}
	
	@Test
	public void AdcionaJornal() throws SQLException {
		Jornal jornal =  new Jornal();
		JornalDao jornaldao = new JornalDao(connection);
		
		jornal.setTitulo("Jornal Nacional");
		jornal.setEdicao("1º Edição");
		jornal.setEditora("Maio");
		jornal.setNumero_paginas(12);
		jornal.setData("2017-11-01");
		
		assertTrue(administrador.AdicionarItem(jornal, jornaldao));
	}
	
	@Test
	public void PesquisaJornal() throws SQLException {
		JornalDao revistadao = new JornalDao(connection);
		Jornal jornalpesquisado = new Jornal();
		
		jornalpesquisado = (Jornal) administrador.PesquisarItem(1, revistadao);
		
		Jornal jornalesperado =  new Jornal();
		jornalesperado.setId(1);
		jornalesperado.setTitulo("Jornal Nacional");
		jornalesperado.setEdicao("1º Edição");
		jornalesperado.setEditora("Barla");
		jornalesperado.setNumero_paginas(12);
		jornalesperado.setData("2017-10-01");
		
		assertEquals(jornalesperado.getId(),jornalpesquisado.getId());
		assertEquals(jornalesperado.getTitulo(),jornalpesquisado.getTitulo());
		assertEquals(jornalesperado.getEdicao(),jornalpesquisado.getEdicao());
		assertEquals(jornalesperado.getEditora(),jornalpesquisado.getEditora());
		assertEquals(jornalesperado.getNumero_paginas(),jornalpesquisado.getNumero_paginas());
		assertEquals(jornalesperado.getData(),jornalpesquisado.getData());
	}
	
	@Test
	public void AlteraJornal() throws SQLException {
		Jornal jornal =  new Jornal();
		
		jornal.setId(2);
		jornal.setTitulo("Jornal Estadual");
		jornal.setEdicao("2º Edição");
		jornal.setEditora("Julho");
		jornal.setNumero_paginas(15);
		jornal.setData("2016-11-01");
		
		JornalDao jornaldao = new JornalDao(connection);
		
		assertTrue(administrador.AlterarItem(jornal, jornaldao));
	}
	
	@Test
	public void RemoveJornal() throws SQLException {
		
	}
	
	@Test
	public void AdcionaAnal() throws SQLException {
		Anal anal =  new Anal();
		AnalDao analdao = new AnalDao(connection);
		
		anal.setTitulo("Seminario Nacional de Literatura");
		anal.setTipo("Artigo");
		anal.setAutores("JK Rowling");
		anal.setLocal("Brasilia");
		anal.setNome_congresso("Hogwarts Congresso");
		anal.setAno_publicacao(2015);
		
		assertTrue(administrador.AdicionarItem(anal, analdao));
	}
	
	@Test
	public void PesquisaAnal() throws SQLException {
		AnalDao analdao = new AnalDao(connection);
		Anal analpesquisado = new Anal();
		
		analpesquisado = (Anal) administrador.PesquisarItem(1, analdao);
		
		Anal analesperado =  new Anal();
		analesperado.setId(1);
		analesperado.setTitulo("Seminario Nacional de Literatura");
		analesperado.setTipo("Artigo");
		analesperado.setAutores("JK Rowling");
		analesperado.setLocal("São Paulo");
		analesperado.setNome_congresso("Hogwarts Congresso");
		analesperado.setAno_publicacao(2015);
		
		assertEquals(analesperado.getId(),analpesquisado.getId());
		assertEquals(analesperado.getTitulo(),analpesquisado.getTitulo());
		assertEquals(analesperado.getTipo(),analpesquisado.getTipo());
		assertEquals(analesperado.getAutores(),analpesquisado.getAutores());
		assertEquals(analesperado.getLocal(),analpesquisado.getLocal());
		assertEquals(analesperado.getNome_congresso(),analpesquisado.getNome_congresso());
		assertEquals(analesperado.getAno_publicacao(),analpesquisado.getAno_publicacao());
	}
	
	@Test
	public void AlteraAnal() throws SQLException {
		Anal anal =  new Anal();
		
		anal.setId(2);
		anal.setTitulo("Seminario de Literatura");
		anal.setTipo("Artigo");
		anal.setAutores("JK Rowling");
		anal.setLocal("Rio de Janeiro");
		anal.setNome_congresso("Hogwarts Congresso 2.0");
		anal.setAno_publicacao(2017);
		
		AnalDao analdao = new AnalDao(connection);
		
		assertTrue(administrador.AlterarItem(anal, analdao));
	}
	
	@Test
	public void RemoveAnal() throws SQLException {
		
	}
	
	@Test
	public void AdcionaTCC() throws SQLException {
		TCC tcc =  new TCC();
		TCCDao tccdao = new TCCDao(connection);
		
		tcc.setTitulo("UML na pratica");
		tcc.setTipo("Monografia");
		tcc.setAutores("Alan Turing");
		tcc.setLocal("Campina Grande");
		tcc.setOrientador("Robert Hulk");
		tcc.setAno_defesa(2010);
		
		assertTrue(administrador.AdicionarItem(tcc, tccdao));
	}
	
	@Test
	public void PesquisaTCC() throws SQLException {
		TCCDao tccdao = new TCCDao(connection);
		TCC tccpesquisado = new TCC();
		
		tccpesquisado = (TCC) administrador.PesquisarItem(1, tccdao);
		
		TCC tccesperado =  new TCC();
		tccesperado.setId(1);
		tccesperado.setTitulo("UML na pratica");
		tccesperado.setTipo("Monografia");
		tccesperado.setAutores("Alan Turing");
		tccesperado.setLocal("Campinas");
		tccesperado.setOrientador("Robert Hulk");
		tccesperado.setAno_defesa(2010);
		
		assertEquals(tccesperado.getId(),tccpesquisado.getId());
		assertEquals(tccesperado.getTitulo(),tccpesquisado.getTitulo());
		assertEquals(tccesperado.getTipo(),tccpesquisado.getTipo());
		assertEquals(tccesperado.getAutores(),tccpesquisado.getAutores());
		assertEquals(tccesperado.getLocal(),tccpesquisado.getLocal());
		assertEquals(tccesperado.getOrientador(),tccpesquisado.getOrientador());
		assertEquals(tccesperado.getAno_defesa(),tccpesquisado.getAno_defesa());
	}
	
	@Test
	public void AlteraTCC() throws SQLException {
		TCC tcc =  new TCC();
		
		tcc.setId(2);
		tcc.setTitulo("UML 2.0");
		tcc.setTipo("Tese");
		tcc.setAutores("Alan Turing");
		tcc.setLocal("Patos");
		tcc.setOrientador("Robert Hulk");
		tcc.setAno_defesa(2014);
		
		TCCDao tccdao = new TCCDao(connection);
		
		assertTrue(administrador.AlterarItem(tcc, tccdao));
	}
	
	@Test
	public void RemoveTCC() throws SQLException {
		
	}
	
	@Test
	public void AdcionaMida() throws SQLException {
		MidiaEletronica midia =  new MidiaEletronica();
		MidiaEletronicaDao midiadao = new MidiaEletronicaDao(connection);
		
		midia.setTitulo("Java Free");
		midia.setTipo("DVD");
		midia.setData_gravacao("2013-03-23");
		
		assertTrue(administrador.AdicionarItem(midia, midiadao));
	}
	
	@Test
	public void PesquisaMidia() throws SQLException {
		MidiaEletronicaDao midiadao = new MidiaEletronicaDao(connection);
		MidiaEletronica midiapesquisada = new MidiaEletronica();
		
		midiapesquisada = (MidiaEletronica) administrador.PesquisarItem(1, midiadao);
		
		MidiaEletronica midiaesperado =  new MidiaEletronica();
		midiaesperado.setId(1);
		midiaesperado.setTitulo("Java Doc");
		midiaesperado.setTipo("DVD");
		midiaesperado.setData_gravacao("2013-03-23");
		
		
		assertEquals(midiaesperado.getId(),midiapesquisada.getId());
		assertEquals(midiaesperado.getTitulo(),midiapesquisada.getTitulo());
		assertEquals(midiaesperado.getTipo(),midiapesquisada.getTipo());
		assertEquals(midiaesperado.getData_gravacao(),midiapesquisada.getData_gravacao());

	}
	
	@Test
	public void AlteraMidia() throws SQLException {
		MidiaEletronica midia =  new MidiaEletronica();
		
		midia.setId(2);
		midia.setTitulo("Java 8");
		midia.setTipo("DVD");
		midia.setData_gravacao("2016-06-29");
		
		MidiaEletronicaDao midiadao = new MidiaEletronicaDao(connection);
		
		assertTrue(administrador.AlterarItem(midia, midiadao));
	}
	
	@Test
	public void RemoveMidia() throws SQLException {
		
	}
	
	@Test
	public void RemoveCurso() throws SQLException {
		
	}
	
	@Test
	public void RemoveAluno() throws SQLException {
		
	}
	
	
	@Test
	public void AdionaFuncionario() throws SQLException {
		FuncionarioDao funcionariodao = new FuncionarioDao(connection);
		Funcionario funcionario = new Funcionario();
		
		funcionario.setCpf("09112345678");
		funcionario.setRg("12345678");
		funcionario.setNaturalidade("Pocinhos");
		funcionario.setNome("Silva Ribeiro");
		funcionario.setEndereco("Avenida do Campo");
		funcionario.setTelefone("08399992222");
		funcionario.setEmail("silva@gmail.com");
		funcionario.setUsuario("avlis");
		funcionario.setSenha("1234");
		
		assertTrue(administrador.AdicionarFuncionario(funcionario,funcionariodao));
	}
	
	@Test
	public void PesquisaFuncionario() throws SQLException {
		FuncionarioDao funcionaridao = new FuncionarioDao(connection);
		Funcionario funcionariopesquisado = new Funcionario();
		
		funcionariopesquisado = administrador.PesquisarFuncionario(2, funcionaridao);
		
		Funcionario funcionarioesperado = new Funcionario();
		
		funcionarioesperado.setId(2);
		funcionarioesperado.setCpf("1052345678");
		funcionarioesperado.setRg("8765478");
		funcionarioesperado.setNaturalidade("Moca");
		funcionarioesperado.setNome("Maria Santos");
		funcionarioesperado.setEndereco("Rua do Campo");
		funcionarioesperado.setTelefone("08388880000");
		funcionarioesperado.setEmail("maria@mail.com");
		funcionarioesperado.setUsuario("Mary");
		funcionarioesperado.setSenha("54321");
		
		assertEquals(funcionarioesperado.getId(),funcionariopesquisado.getId());
		assertEquals(funcionarioesperado.getCpf(),funcionariopesquisado.getCpf());
		assertEquals(funcionarioesperado.getRg(),funcionariopesquisado.getRg());
		assertEquals(funcionarioesperado.getNaturalidade(),funcionariopesquisado.getNaturalidade());
		assertEquals(funcionarioesperado.getNome(),funcionariopesquisado.getNome());
		assertEquals(funcionarioesperado.getEndereco(),funcionariopesquisado.getEndereco());
		assertEquals(funcionarioesperado.getTelefone(),funcionariopesquisado.getTelefone());
		assertEquals(funcionarioesperado.getEmail(),funcionariopesquisado.getEmail());
		assertEquals(funcionarioesperado.getUsuario(),funcionariopesquisado.getUsuario());
		assertEquals(funcionarioesperado.getSenha(),funcionariopesquisado.getSenha());
	}
	
	@Test
	public void AlteraFuncionario() throws SQLException {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setId(4);
		funcionario.setCpf("09112345678");
		funcionario.setRg("12345678");
		funcionario.setNaturalidade("Soledade");
		funcionario.setNome("Silva Ribeiro Campos");
		funcionario.setEndereco("Rua do Milho");
		funcionario.setTelefone("08399992222");
		funcionario.setEmail("silva@gmail.com");
		funcionario.setUsuario("avlis");
		funcionario.setSenha("1234");
		
		FuncionarioDao funcionariodao = new FuncionarioDao(connection);
		
		assertTrue(administrador.AlterarFuncionario(funcionario,funcionariodao));
	}
	
	@Test
	public void RemoveFuncionario() throws SQLException {
		
	}

	@Test
	public void AdionaAdministrador() throws SQLException {
		AdministradorDao administradordao = new AdministradorDao(connection);
		Administrador adm = new Administrador();
		
		adm.setCpf("09112345678");
		adm.setRg("12345678");
		adm.setNaturalidade("Pocinhos");
		adm.setNome("Silvio Telo");
		adm.setEndereco("Avenida do Campo");
		adm.setTelefone("08399992222");
		adm.setEmail("silvio@gmail.com");
		adm.setUsuario("oivlis");
		adm.setSenha("1234");
		
		assertTrue(administrador.AdicionarAdministardor(adm,administradordao));
	}
	
	@Test
	public void PesquisaAdministrador() throws SQLException {
		AdministradorDao adiministadormdao = new AdministradorDao(connection);
		Administrador admpesquisado = new Administrador();
		
		admpesquisado = administrador.PesquisarAdministardor(2, adiministadormdao);
		
		Administrador admesperado = new Administrador();
		
		admesperado.setId(2);
		admesperado.setCpf("09816785678");
		admesperado.setRg("12345634");
		admesperado.setNaturalidade("Pocinhos");
		admesperado.setNome("Tereza Telo");
		admesperado.setEndereco("Avenida do Campo");
		admesperado.setTelefone("08399992222");
		admesperado.setEmail("tereza@gmail.com");
		admesperado.setUsuario("tete");
		admesperado.setSenha("12345");
		
		assertEquals(admesperado.getId(),admpesquisado.getId());
		assertEquals(admesperado.getCpf(),admpesquisado.getCpf());
		assertEquals(admesperado.getRg(),admpesquisado.getRg());
		assertEquals(admesperado.getNaturalidade(),admpesquisado.getNaturalidade());
		assertEquals(admesperado.getNome(),admpesquisado.getNome());
		assertEquals(admesperado.getEndereco(),admpesquisado.getEndereco());
		assertEquals(admesperado.getTelefone(),admpesquisado.getTelefone());
		assertEquals(admesperado.getEmail(),admpesquisado.getEmail());
		assertEquals(admesperado.getUsuario(),admpesquisado.getUsuario());
		assertEquals(admesperado.getSenha(),admpesquisado.getSenha());
	}
	
	@Test
	public void AlteraAdministrador() throws SQLException {
		Administrador adm = new Administrador();
		
		adm.setId(2);
		adm.setCpf("09816785678");
		adm.setRg("12345634");
		adm.setNaturalidade("Pocinhos");
		adm.setNome("Tereza Telo");
		adm.setEndereco("Avenida do Campo");
		adm.setTelefone("08399992222");
		adm.setEmail("tereza@gmail.com");
		adm.setUsuario("tete");
		adm.setSenha("12345");
		
		AdministradorDao administradordao = new AdministradorDao(connection);
		
		assertTrue(administrador.AlterarAdministardor(adm,administradordao));
	}
	
	@Test
	public void RemoveAdministrador() throws SQLException {
		
	}
}

