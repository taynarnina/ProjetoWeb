package br.edu.ufab.test.pessoas;

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
import br.edu.ufab.model.entities.Curso;
import br.edu.ufab.model.entities.pessoas.Aluno;
import br.edu.ufab.model.enums.AreaDeCurso;
import br.edu.ufab.model.enums.PeriodoDeIngresso;
import br.edu.ufab.model.enums.TipoDeCurso;
import br.edu.ufab.model.repositories.CursoRepository;
import br.edu.ufab.model.repositories.EmprestimoRepository;
import br.edu.ufab.model.repositories.pessoas.AlunoRepository;
import br.edu.ufab.test.config.H2DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class,H2DataSource.class,EmprestimoRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class AlunoTest {

	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	
	@Test
	public void salvarTest() {
		
		Curso c1 = new Curso();
		c1.setId(1);
		c1.setArea(AreaDeCurso.CIENCIAS_EXATAS);
		c1.setCodigo("CC");
		c1.setNome("Ciencia da Computacao");
		c1.setTipo(TipoDeCurso.G);
		
		cursoRepository.save(c1);
		
		Aluno a1 = new Aluno();
		a1.setId(1);
		a1.setAno(2014);
		a1.setRg("26542873");
		a1.setCpf("123456789");
		a1.setCurso(cursoRepository.findOne((long) 1));
		a1.setDatanascimento("17/10/1995");
		a1.setEmail("meuemail@gmail.com");
		a1.setEndereco("Rua das tintas");
		a1.setMatricula("GCC-141010");
		a1.setNaturalidade("Campina Grande");
		a1.setNome("Maria Clara");
		a1.setNomemae("Noemi silva");
		a1.setPeriodo(PeriodoDeIngresso.PRIMEIRO);
		a1.setSenha("123456");
		a1.setTelefone("98875-8083");
		
		alunoRepository.save(a1);
		
		Aluno a2 = new Aluno();
		a2 = alunoRepository.findOne((long) 1);
		
		assertEquals(a2.getId(),a1.getId());
		assertEquals(a2.getRg(),a1.getRg());
		assertEquals(a2.getCpf(),a1.getCpf());
		assertEquals(a2.getDatanascimento(),a1.getDatanascimento());
		assertEquals(a2.getEmail(),a1.getEmail());
		assertEquals(a2.getEndereco(),a1.getEndereco());
		assertEquals(a2.getMatricula(),a1.getMatricula());
		assertEquals(a2.getNaturalidade(),a1.getNaturalidade());
		assertEquals(a2.getNome(),a1.getNome());
		assertEquals(a2.getNomemae(),a1.getNomemae());
		assertEquals(a2.getPeriodo(),a1.getPeriodo());
		assertEquals(a2.getSenha(),a1.getSenha());
		assertEquals(a2.getTelefone(),a1.getTelefone());
		
		/*No método salvar também testamos o método buscar (findOne)*/
	}
	
	@Test
	public void removerTest() {
		Curso c1 = new Curso();
		c1.setId(1);
		c1.setArea(AreaDeCurso.CIENCIAS_EXATAS);
		c1.setCodigo("CC");
		c1.setNome("Ciencia da Computacao");
		c1.setTipo(TipoDeCurso.G);
		
		cursoRepository.save(c1);
		
		Aluno a1 = new Aluno();
		a1.setId(1);
		a1.setAno(2014);
		a1.setRg("26542873");
		a1.setCpf("123456789");
		a1.setCurso(cursoRepository.findOne((long) 1));
		a1.setDatanascimento("17/10/1995");
		a1.setEmail("meuemail@gmail.com");
		a1.setEndereco("Rua das tintas");
		a1.setMatricula("GCC-141010");
		a1.setNaturalidade("Campina Grande");
		a1.setNome("Maria Clara");
		a1.setNomemae("Noemi silva");
		a1.setPeriodo(PeriodoDeIngresso.PRIMEIRO);
		a1.setSenha("123456");
		a1.setTelefone("98875-8083");
		
		alunoRepository.save(a1);
		alunoRepository.delete(a1);
		
		assertFalse(alunoRepository.exists((long) 1));
	}
}
