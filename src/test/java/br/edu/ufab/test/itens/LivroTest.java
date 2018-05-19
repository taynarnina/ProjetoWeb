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
import br.edu.ufab.model.entities.itens.Livro;
import br.edu.ufab.model.repositories.AutorRepository;
import br.edu.ufab.model.repositories.EditoraRepository;
import br.edu.ufab.model.repositories.itens.LivroRepository;
import br.edu.ufab.test.config.H2DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class,H2DataSource.class,AutorRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class LivroTest {

	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private EditoraRepository editoraRepository;
	
	@Test
	public void salvarTest() {
		Editora e1 = new Editora();
		e1.setId(1);
		e1.setNome("Abril");
		
		editoraRepository.save(e1);
		
		Livro l1 = new Livro();
		l1.setId(1);
		l1.setTitulo("Livro");
		l1.setEdicao("edicao");
		l1.setEditora(editoraRepository.findOne((long) 1));
		l1.setIsbn("3243574678576");
		l1.setNumpaginas(127);
		
		livroRepository.save(l1);
		
		Livro l2 = new Livro();
		l2 = livroRepository.findOne((long) 1);
		
		assertEquals(l2.getId(),l1.getId());
		assertEquals(l2.getTitulo(),l1.getTitulo());
		assertEquals(l2.getEdicao(),l1.getEdicao());
		//assertEquals(l2.getEditora(),l1.getEditora());
		assertEquals(l2.getIsbn(),l1.getIsbn());
		assertEquals(l2.getNumpaginas(),l1.getNumpaginas());
		
		/*No método salvar também testamos o método buscar (findOne)*/
	}
	
	@Test
	public void removerTest() {
		Livro l1 = new Livro();
		l1.setId(1);
		l1.setTitulo("Livro");
		l1.setEdicao("edicao");
		l1.setIsbn("3243574678576");
		l1.setNumpaginas(127);
		
		livroRepository.save(l1);
		livroRepository.delete(l1);
		
		assertFalse(livroRepository.exists((long) 1));
	}
}
