package br.edu.ufab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ufab.exception.Exception;
import br.edu.ufab.model.entities.Emprestimo;
import br.edu.ufab.model.entities.itens.Anais;
import br.edu.ufab.model.entities.itens.Jornal;
import br.edu.ufab.model.entities.itens.Livro;
import br.edu.ufab.model.entities.itens.MidiaEletronica;
import br.edu.ufab.model.entities.itens.Revista;
import br.edu.ufab.model.entities.itens.TCC;
import br.edu.ufab.model.entities.pessoas.Aluno;
import br.edu.ufab.model.repositories.EmprestimoRepository;
import br.edu.ufab.model.repositories.itens.AnaisRepository;
import br.edu.ufab.model.repositories.itens.JornalRepository;
import br.edu.ufab.model.repositories.itens.LivroRepository;
import br.edu.ufab.model.repositories.itens.MidiaEletronicaRepository;
import br.edu.ufab.model.repositories.itens.RevistaRepository;
import br.edu.ufab.model.repositories.itens.TCCRepository;
import br.edu.ufab.model.repositories.pessoas.AlunoRepository;
import br.edu.ufab.propertyeditors.itens.AnaisPropertyEditor;
import br.edu.ufab.propertyeditors.itens.JornalPropertyEditor;
import br.edu.ufab.propertyeditors.itens.LivroPropertyEditor;
import br.edu.ufab.propertyeditors.itens.MidiaEletronicaPropertyEditor;
import br.edu.ufab.propertyeditors.itens.RevistaPropertyEditor;
import br.edu.ufab.propertyeditors.itens.TCCPropertyEditor;
import br.edu.ufab.propertyeditors.pessoas.AlunoPropertyEditor;
/**
 * Classe responsável pelo controle das operações em Empréstimo, manipulando os dados
 * no banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {
	/**
	 *São chamados os PropertyEditor e Repository de alunos,editora,jornal,
	 *anais,livros, revistas,mídia eletrônica e tcc.
	 * */
	@Autowired AlunoPropertyEditor alunoPropertyEditor;
	@Autowired AlunoRepository alunoRepository;
	@Autowired AnaisPropertyEditor anaisPropertyEditor;
	@Autowired AnaisRepository anaisRepository;
	@Autowired JornalPropertyEditor jornalPropertyEditor;
	@Autowired JornalRepository jornalRepository;
	@Autowired LivroPropertyEditor livroPropertyEditor;
	@Autowired LivroRepository livroRepository;
	@Autowired MidiaEletronicaPropertyEditor midiaPropertyEditor;
	@Autowired MidiaEletronicaRepository midiaRepository;
	@Autowired RevistaPropertyEditor revistaPropertyEditor;
	@Autowired RevistaRepository revistaRepository;
	@Autowired TCCPropertyEditor tccPropertyEditor;
	@Autowired TCCRepository tccRepository;
	@Autowired EmprestimoRepository emprestimoRepository;
	
	/**
	 * método que recebe os dados que estão no bd e mostra na tela a lista dos dados
	 * @param model
	 * */
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarEmprestimo(Model model) {
		Iterable<Emprestimo> emprestimos = emprestimoRepository.findAll();
		model.addAttribute("titulo", "Lista de Emprestimos");
		model.addAttribute("emprestimos",emprestimos);
		model.addAttribute("alunos",alunoRepository.findAll());
		model.addAttribute("anais",anaisRepository.findAll());
		model.addAttribute("jornais",jornalRepository.findAll());
		model.addAttribute("livros",livroRepository.findAll());
		model.addAttribute("midias",midiaRepository.findAll());
		model.addAttribute("revistas",revistaRepository.findAll());
		model.addAttribute("tccs",tccRepository.findAll());
		return "emprestimo/lista";
	}
	
	/**
	 * método que recebe os dados que o usuário preencheu na tela
	 * e envia para o banco de dados.
	 * @param bindingResult,model
	 * */
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarEmprestimo(
			@Valid @ModelAttribute Emprestimo emprestimo,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			emprestimoRepository.save(emprestimo);
		}
		
		model.addAttribute("emprestimos",emprestimoRepository.findAll());
		return "emprestimo/tabela-emprestimos";
	}
	
	/**
	 * método que recebe o id do objeto que o usuário deseja devolver
	 * e apaga no banco de dados.
	 * @param id
	 * */
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> devolverEmprestimo(@PathVariable Long id) {
		try {
			emprestimoRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * método que recebe o id do objeto que o usuário deseja 
	 * e apresenta na tela.
	 * @param id
	 * */
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Emprestimo buscarEmprestimo(@PathVariable Long id){
		Emprestimo emprestimo = emprestimoRepository.findOne(id);
		return emprestimo;
	}
	/**
	 * método que recebe um objeto e retorna os id's para mapear no banco de de dados.
	 * @param id
	 * */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Aluno.class, alunoPropertyEditor);
		webDataBinder.registerCustomEditor(Anais.class, anaisPropertyEditor);
		webDataBinder.registerCustomEditor(Jornal.class, jornalPropertyEditor);
		webDataBinder.registerCustomEditor(Livro.class, livroPropertyEditor);
		webDataBinder.registerCustomEditor(MidiaEletronica.class, midiaPropertyEditor);
		webDataBinder.registerCustomEditor(Revista.class, revistaPropertyEditor);
		webDataBinder.registerCustomEditor(TCC.class, tccPropertyEditor);
	}
}
