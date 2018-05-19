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
import br.edu.ufab.model.entities.Emprestimo;
import br.edu.ufab.model.repositories.EmprestimoRepository;
import br.edu.ufab.test.config.H2DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class,H2DataSource.class,EmprestimoRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class EmprestimoTest {
		
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@Test
	public void salvarTest() {
		Emprestimo e1 = new Emprestimo();
		e1.setId(1);
		e1.setDatadevolucao("01/06/2018");
		e1.setDataemprestimo("18/05/2018");
		
		emprestimoRepository.save(e1);
		
		Emprestimo e2 = new Emprestimo();
		e2 = emprestimoRepository.findOne((long) 1);
		
		assertEquals(e2.getId(),e1.getId());
		assertEquals(e2.getDatadevolucao(),e1.getDatadevolucao());
		assertEquals(e2.getDataemprestimo(),e1.getDataemprestimo());
		
		/*No método salvar também testamos o método buscar (findOne)*/	
	}
	
	
	@Test
	public void removerTest() {
		
		Emprestimo e1 = new Emprestimo();
		e1.setId(1);
		e1.setDatadevolucao("01/06/2018");
		e1.setDataemprestimo("18/05/2018");
		
		emprestimoRepository.save(e1);
		emprestimoRepository.delete(e1);
		
		assertFalse(emprestimoRepository.exists((long) 1));
	}	
}
