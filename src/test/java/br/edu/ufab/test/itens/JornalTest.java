package br.edu.ufab.test.itens;

import static org.junit.Assert.*;

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
import br.edu.ufab.model.entities.itens.Jornal;
import br.edu.ufab.model.repositories.AutorRepository;
import br.edu.ufab.model.repositories.EditoraRepository;
import br.edu.ufab.model.repositories.itens.JornalRepository;
import br.edu.ufab.test.config.H2DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class,H2DataSource.class,AutorRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class JornalTest {

	@Autowired
	private JornalRepository jornalRepository;
	@Autowired
	private EditoraRepository editoraRepository;
	
	@Test
	public void salvarTest() {
		Editora e1 = new Editora();
		e1.setId(1);
		e1.setNome("Abril");
		
		editoraRepository.save(e1);
		
		Jornal j1 = new Jornal();
		j1.setId(1);
		j1.setTitulo("Jornal");
		j1.setNumpaginas(16);
		j1.setEditora(editoraRepository.findOne((long) 1));
		j1.setEdicao("Primeira");
		j1.setData("22/02/2015");
		
		jornalRepository.save(j1);
		
		Jornal j2 = new Jornal();
		j2 = jornalRepository.findOne((long) 1);
		
		assertEquals(j2.getId(),j1.getId());
		assertEquals(j2.getTitulo(),j1.getTitulo());
		assertEquals(j2.getNumpaginas(),j1.getNumpaginas());
		//assertEquals(j2.getEditora(),j1.getEditora());
		assertEquals(j2.getEdicao(),j1.getEdicao());
		assertEquals(j2.getData(),j1.getData());
		
		/*No método salvar também testamos o método buscar (findOne)*/
	}
	
	@Test
	public void removerTest() {
		Jornal j1 = new Jornal();
		j1.setId(1);
		j1.setTitulo("Jornal");
		j1.setNumpaginas(16);
		j1.setEdicao("Primeira");
		j1.setData("22/02/2015");
		
		jornalRepository.save(j1);
		jornalRepository.delete(j1);
		
		assertFalse(jornalRepository.exists((long) 1));
	}
}
