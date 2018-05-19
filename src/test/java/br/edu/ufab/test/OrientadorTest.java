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
import br.edu.ufab.model.entities.Orientador;
import br.edu.ufab.model.repositories.OrientadorRepository;
import br.edu.ufab.test.config.H2DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class,H2DataSource.class,OrientadorRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class OrientadorTest {
		
	@Autowired
	private OrientadorRepository orientadorRepository;
	
	@Test
	public void salvarTest() {
		Orientador o1 = new Orientador();
		o1.setId(1);
		o1.setNome("mariadb");
		
		orientadorRepository.save(o1);
		
		Orientador o2 = new Orientador();
		o2 = orientadorRepository.findOne((long) 1);

		assertEquals(o2.getId(),o1.getId());
		assertEquals(o2.getNome(),o1.getNome());
		
		/*No método salvar também testamos o método buscar (findOne)*/	
	}
	
	@Test
	public void removerTest() {
		Orientador o1 = new Orientador();
		o1.setId(1);
		o1.setNome("mariadb");
		
		orientadorRepository.save(o1);
		orientadorRepository.delete(o1);
		
		assertFalse(orientadorRepository.exists((long) 1));
	}	
}
