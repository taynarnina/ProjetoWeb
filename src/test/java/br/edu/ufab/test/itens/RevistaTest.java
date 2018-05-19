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
import br.edu.ufab.model.entities.Editora;
import br.edu.ufab.model.entities.itens.Revista;
import br.edu.ufab.model.repositories.EditoraRepository;
import br.edu.ufab.model.repositories.itens.RevistaRepository;
import br.edu.ufab.test.config.H2DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class,H2DataSource.class,RevistaRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class RevistaTest {
		
	@Autowired
	private RevistaRepository revistaRepository;
	@Autowired
	private EditoraRepository editoraRepository;
	
	@Test
	public void salvarTest() {
		Editora e1 = new Editora();
		e1.setId(1);
		e1.setNome("Abril");
		
		editoraRepository.save(e1);
		
		Revista r1 = new Revista();
		r1.setId(1);
		r1.setTitulo("Caras e Bocas");
		r1.setDatapublicacao("17/05/2015");
		r1.setEdicao("1");
		r1.setEditora(editoraRepository.findOne((long) 1));
		r1.setNumpaginas(33);
		
		revistaRepository.save(r1);
		
		Revista r2 = new Revista();
		r2 = revistaRepository.findOne((long) 1);
		
		assertEquals(r2.getId(),r1.getId());
		assertEquals(r2.getTitulo(),r1.getTitulo());
		//assertEquals(r2.getEditora(),r1.getEditora());
		assertEquals(r2.getEdicao(),r1.getEdicao());
		assertEquals(r2.getNumpaginas(),r1.getNumpaginas());
		assertEquals(r2.getDatapublicacao(),r1.getDatapublicacao());
	
		/*No método salvar também testamos o método buscar (findOne)*/	
	}
	
	@Test
	public void removerTest() {
		Editora e1 = new Editora();
		e1.setId(1);
		e1.setNome("Abril");
		
		editoraRepository.save(e1);
		
		Revista r1 = new Revista();
		r1.setId(1);
		r1.setTitulo("Caras e Bocas");
		r1.setDatapublicacao("17/05/2015");
		r1.setEdicao("1");
		r1.setEditora(editoraRepository.findOne((long) 1));
		r1.setNumpaginas(33);
		
		revistaRepository.save(r1);
		revistaRepository.delete(r1);
		
		assertFalse(revistaRepository.exists((long) 1));	
	}
}