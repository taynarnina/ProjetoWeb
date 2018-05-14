package br.edu.ufab.controller.pessoas;

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
import br.edu.ufab.model.entities.Curso;
import br.edu.ufab.model.entities.pessoas.Aluno;
import br.edu.ufab.model.enums.PeriodoDeIngresso;
import br.edu.ufab.model.repositories.CursoRepository;
import br.edu.ufab.model.repositories.pessoas.AlunoRepository;
import br.edu.ufab.propertyeditors.CursoPropertyEditor;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired private CursoPropertyEditor cursoPropertyEditor;
	@Autowired private CursoRepository cursoRepository;
	@Autowired private AlunoRepository alunoRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaAlunos(Model model) {
		Iterable<Aluno> alunos = alunoRepository.findAll();
		model.addAttribute("titulo", "Lista de Alunos");
		model.addAttribute("alunos",alunos);
		model.addAttribute("periodos",PeriodoDeIngresso.values());
		model.addAttribute("cursos",cursoRepository.findAll());
		return "pessoas/aluno/lista";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarAluno(
			@Valid @ModelAttribute Aluno aluno,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			alunoRepository.save(aluno);
		}
		
		model.addAttribute("alunos",alunoRepository.findAll());
		model.addAttribute("periodos",PeriodoDeIngresso.values());
		model.addAttribute("cursos",cursoRepository.findAll());
		return "pessoas/aluno/tabela-alunos";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarAluno(@PathVariable Long id) {
		try {
			alunoRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Aluno buscarAluno(@PathVariable Long id){
		Aluno aluno = alunoRepository.findOne(id);
		return aluno;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Curso.class, cursoPropertyEditor);
	}
}
