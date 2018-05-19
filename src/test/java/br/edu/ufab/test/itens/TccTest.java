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
import br.edu.ufab.model.entities.itens.TCC;
import br.edu.ufab.model.enums.TipoDeTCC;
import br.edu.ufab.model.repositories.itens.TCCRepository;
import br.edu.ufab.test.config.H2DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class,H2DataSource.class,TCCRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class TccTest {
		
	@Autowired
	private TCCRepository tccRepository;
	
	@Test
	public void salvarTest() {
		TCC t1 = new TCC();
		t1.setId(1);
		t1.setLocal("UEPB");
		t1.setTipo(TipoDeTCC.MONOGRAFIA);
		t1.setTitulo("Programacao Web com Spring MVC");
		
		tccRepository.save(t1);
		
		TCC t2 = new TCC();
		t2 = tccRepository.findOne((long) 1);
		
		assertEquals(t2.getId(),t1.getId());
		assertEquals(t2.getTitulo(),t1.getTitulo());
		assertEquals(t2.getLocal(),t1.getLocal());
		assertEquals(t2.getTipo(),t1.getTipo());
		
		/*No método salvar também testamos o método buscar (findOne)*/	
	}	
	
	@Test
	public void removerTest() {
		TCC t1 = new TCC();
		t1.setId(1);
		t1.setLocal("UEPB");
		t1.setTipo(TipoDeTCC.MONOGRAFIA);
		t1.setTitulo("Programacao Web com Spring MVC");
		
		tccRepository.save(t1);
		tccRepository.delete(t1);
		
		assertFalse(tccRepository.exists((long) 1));
	}	
}
