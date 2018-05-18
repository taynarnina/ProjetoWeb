package br.edu.ufab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ufab.exception.Exception;
import br.edu.ufab.model.entities.Curso;
import br.edu.ufab.model.enums.AreaDeCurso;
import br.edu.ufab.model.enums.TipoDeCurso;
import br.edu.ufab.model.repositories.CursoRepository;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired private CursoRepository cursoRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaCursos(Model model) {
		Iterable<Curso> cursos = cursoRepository.findAll();
		model.addAttribute("titulo", "Lista de Cursos");
		model.addAttribute("cursos",cursos);
		model.addAttribute("areas",AreaDeCurso.values());
		model.addAttribute("tipos",TipoDeCurso.values());
		return "outros/curso/lista";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarCurso(
			@Valid @ModelAttribute Curso curso,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			cursoRepository.save(curso);
		}
		
		model.addAttribute("cursos",cursoRepository.findAll());
		return "outros/curso/tabela-cursos";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarCurso(@PathVariable Long id) {
		try {
			cursoRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Curso buscarCurso(@PathVariable Long id){
		Curso curso = cursoRepository.findOne(id);
		return curso;
	}
}
