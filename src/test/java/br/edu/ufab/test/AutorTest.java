package br.edu.ufab.test;

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
import br.edu.ufab.model.entities.Autor;
import br.edu.ufab.model.repositories.AutorRepository;
import br.edu.ufab.test.config.H2DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class,H2DataSource.class,AutorRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class AutorTest {
		
	@Autowired
	private AutorRepository autorRepository;
	
	@Test
	public void salvarTest() {
		Autor a1 = new Autor();
		a1.setId(1);
		a1.setNome("mariadb");
		
		autorRepository.save(a1);
		
		Autor a2 = new Autor();
		a2 = autorRepository.findOne((long) 1);
		
		assertEquals(a2.getId(),a1.getId());
		assertEquals(a2.getNome(),a1.getNome());
		
		/*No método salvar também testamos o método buscar (findOne)*/	
	}
	
	@Test
	public void removerTest() {
		Autor a1 = new Autor();
		a1.setId(1);
		a1.setNome("mariadb");
		
		autorRepository.save(a1);
		autorRepository.delete(a1);
		
		assertFalse(autorRepository.exists((long) 1));	
	}
}
