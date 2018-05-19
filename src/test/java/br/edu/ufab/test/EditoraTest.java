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
import br.edu.ufab.model.entities.Editora;
import br.edu.ufab.model.repositories.EditoraRepository;
import br.edu.ufab.test.config.H2DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class,H2DataSource.class,EditoraRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class EditoraTest {
		
	@Autowired
	private EditoraRepository editoraRepository;
	
	@Test
	public void salvarTest() {
		Editora ed1 = new Editora();
		ed1.setId(1);
		ed1.setNome("mariadb");
		
		editoraRepository.save(ed1);
		
		Editora ed2 = new Editora();
		ed2 = editoraRepository.findOne((long) 1);
		
		assertEquals(ed2.getId(),ed1.getId());
		assertEquals(ed2.getNome(),ed1.getNome());
		
		/*No método salvar também testamos o método buscar (findOne)*/	
	}
	
	@Test
	public void removerTest() {
		Editora ed1 = new Editora();
		ed1.setId(1);
		ed1.setNome("mariadb");
		editoraRepository.save(ed1);
		editoraRepository.delete(ed1);
		
		assertFalse(editoraRepository.exists((long) 1));
	}
}
