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

import br.edu.ufab.model.entities.itens.MidiaEletronica;
import br.edu.ufab.model.enums.TipoDeMidia;
import br.edu.ufab.model.repositories.itens.MidiaEletronicaRepository;
import br.edu.ufab.test.config.H2DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class,H2DataSource.class,MidiaEletronicaRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class MidiaEletronicaTest {
		
	@Autowired
	private MidiaEletronicaRepository midiaEletronicaRepository;
	
	@Test
	public void salvarTest() {
		MidiaEletronica m1 = new MidiaEletronica();
		m1.setId(1);
		m1.setTitulo("Grupo Logos");
		m1.setTipo(TipoDeMidia.DVD);
		m1.setData("21/10/1999");
		
		midiaEletronicaRepository.save(m1);
		
		MidiaEletronica m2 = new MidiaEletronica();
		m2 = midiaEletronicaRepository.findOne((long) 1);
		
		assertEquals(m2.getData(),m1.getData());
		assertEquals(m2.getTitulo(),m1.getTitulo());
		assertEquals(m2.getId(),m1.getId());
		assertEquals(m2.getTipo(),m1.getTipo());
		
		/*No método salvar também testamos o método buscar (findOne)*/	
	}
	
	@Test
	public void removerTest() {
		MidiaEletronica m1 = new MidiaEletronica();
		m1.setId(1);
		m1.setTitulo("Grupo Logos");
		m1.setTipo(TipoDeMidia.DVD);
		m1.setData("21/10/1999");
		
		midiaEletronicaRepository.save(m1);
		midiaEletronicaRepository.delete(m1);
		
		assertFalse(midiaEletronicaRepository.exists((long) 1));
	}
}
