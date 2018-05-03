package br.edu.ufab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		return "curso/lista";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarCurso(
			@Valid @ModelAttribute Curso curso,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		
		if ( bindingResult.hasErrors() ) {
			FieldError error = bindingResult.getFieldErrors().get(0);
			redirectAttributes.addFlashAttribute("mensagemErro", "Não foi possivel salvar o curso. "+error.getField()+" "+error.getDefaultMessage());
		} else {
			cursoRepository.save(curso);
			redirectAttributes.addFlashAttribute("mensagemInfo", "O curso foi salvo com sucesso.");
		}
		
		return "redirect:/curso";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	public ResponseEntity<String> deletarCurso(@PathVariable Long id) {
		try {
			cursoRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
