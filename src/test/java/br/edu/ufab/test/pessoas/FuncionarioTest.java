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
import br.edu.ufab.model.entities.pessoas.Funcionario;
import br.edu.ufab.model.enums.NivelDeFuncionario;
import br.edu.ufab.model.repositories.EmprestimoRepository;
import br.edu.ufab.model.repositories.pessoas.FuncionarioRepository;
import br.edu.ufab.test.config.H2DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class,H2DataSource.class,EmprestimoRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class FuncionarioTest {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Test
	public void salvarTest() {
		Funcionario f = new Funcionario();
		f.setId(1);
		f.setRg("26542873");
		f.setCpf("123456789");
		f.setDatanascimento("17/10/1995");
		f.setEmail("meuemail@gmail.com");
		f.setEndereco("Rua das tintas");
		f.setNaturalidade("Campina Grande");
		f.setNome("Maria Clara");
		f.setNivel(NivelDeFuncionario.ADMINISTRADOR);
		f.setUsuario("adm");
		f.setSenha("123456");
		f.setTelefone("98875-8083");
		
		funcionarioRepository.save(f);
		
		Funcionario f2 = new Funcionario();
		f2 = funcionarioRepository.findOne((long) 1);
		
		assertEquals(f2.getId(),f.getId());
		assertEquals(f2.getRg(),f.getRg());
		assertEquals(f2.getCpf(),f.getCpf());
		assertEquals(f2.getDatanascimento(),f.getDatanascimento());
		assertEquals(f2.getEmail(),f.getEmail());
		assertEquals(f2.getEndereco(),f.getEndereco());
		assertEquals(f2.getNaturalidade(),f.getNaturalidade());
		assertEquals(f2.getNome(),f.getNome());
		assertEquals(f2.getNivel(),f.getNivel());
		assertEquals(f2.getUsuario(),f.getUsuario());
		assertEquals(f.getSenha(),f.getSenha());
		assertEquals(f2.getTelefone(),f.getTelefone());
		
		/*No método salvar também testamos o método buscar (findOne)*/
	}
	
	@Test
	public void removerTest() {
		Funcionario f = new Funcionario();
		f.setId(1);
		f.setRg("26542873");
		f.setCpf("123456789");
		f.setDatanascimento("17/10/1995");
		f.setEmail("meuemail@gmail.com");
		f.setEndereco("Rua das tintas");
		f.setNaturalidade("Campina Grande");
		f.setNome("Maria Clara");
		f.setNivel(NivelDeFuncionario.ADMINISTRADOR);
		f.setUsuario("adm");
		f.setSenha("123456");
		f.setTelefone("98875-8083");
		
		funcionarioRepository.save(f);
		funcionarioRepository.delete(f);
		
		assertFalse(funcionarioRepository.exists((long) 1));
	}
}
