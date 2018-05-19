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
import br.edu.ufab.model.enums.AreaDeCurso;
import br.edu.ufab.model.enums.TipoDeCurso;
import br.edu.ufab.model.entities.Curso;
import br.edu.ufab.model.repositories.CursoRepository;
import br.edu.ufab.test.config.H2DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class,H2DataSource.class,CursoRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class CursoTest {
		
	@Autowired
	private CursoRepository cursoRepository;
	
	@Test
	public void salvarTest() {
		Curso c1 = new Curso();
		c1.setId(1);
		c1.setArea(AreaDeCurso.CIENCIAS_EXATAS);
		c1.setCodigo("cc");
		c1.setNome("Ciencia da computacao");
		c1.setTipo(TipoDeCurso.G);
		
		cursoRepository.save(c1);
		
		Curso c2 = new Curso();
		c2 = cursoRepository.findOne((long) 1);
		
		assertEquals(c2.getId(),c1.getId());
		assertEquals(c2.getArea(),c1.getArea());
		assertEquals(c2.getCodigo(),c1.getCodigo());
		assertEquals(c2.getNome(),c1.getNome());
		assertEquals(c2.getTipo(),c1.getTipo());
		
		/*No método salvar também testamos o método buscar (findOne)*/	
	}
	
	@Test
	public void removerTest() {
		Curso c1 = new Curso();
		c1.setId(1);
		c1.setArea(AreaDeCurso.CIENCIAS_EXATAS);
		c1.setCodigo("cc");
		c1.setNome("Ciencia da computacao");
		c1.setTipo(TipoDeCurso.G);
		
		cursoRepository.save(c1);
		cursoRepository.delete(c1);
		
		assertFalse(cursoRepository.exists((long) 1));
	}
}
