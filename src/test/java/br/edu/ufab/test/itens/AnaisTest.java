package br.edu.ufab.test.itens;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import br.edu.ufab.Application;
import br.edu.ufab.model.entities.itens.Anais;
import br.edu.ufab.model.enums.TipoDeAnais;
import br.edu.ufab.model.repositories.AutorRepository;
import br.edu.ufab.model.repositories.itens.AnaisRepository;
import br.edu.ufab.test.config.H2DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class,H2DataSource.class,AutorRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class AnaisTest {
		
	@Autowired
	private AnaisRepository anaisRepository;
	
	@Test
	public void salvarTest() {
		Anais an1 = new Anais();
		an1.setId(1);
		an1.setLocal("Campina Grande");
		an1.setNomecongreco("ENECT");
		an1.setTitulo("Analise dos livros de Fernando Pessoa");
		an1.setTipo(TipoDeAnais.POSTER);
		
		anaisRepository.save(an1);
		
		Anais an2 = new Anais();
		an2 = anaisRepository.findOne((long) 1);
		
		assertEquals(an2.getId(),an1.getId());
		assertEquals(an2.getTitulo(),an1.getTitulo());
		assertEquals(an2.getLocal(),an1.getLocal());
		assertEquals(an2.getNomecongreco(),an1.getNomecongreco());
		assertEquals(an2.getTipo(),an1.getTipo());
		
		/*No método salvar também testamos o método buscar (findOne)*/	
	}
	
	@Test
	public void removerTest() {
		Anais an1 = new Anais();
		an1.setId(1);
		an1.setLocal("Campina Grande");
		an1.setNomecongreco("ENECT");
		an1.setTitulo("Analise dos livros de Fernando Pessoa");
		an1.setTipo(TipoDeAnais.POSTER);
		
		anaisRepository.save(an1);
		anaisRepository.delete(an1);
		
		assertFalse(anaisRepository.exists((long) 1));
	}
}
