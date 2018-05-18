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
import br.edu.ufab.model.entities.Autor;
import br.edu.ufab.model.repositories.AutorRepository;

@Controller
@RequestMapping("/autor")
public class AutorController {

	@Autowired private AutorRepository autorRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaAutores(Model model) {
		Iterable<Autor> autores = autorRepository.findAll();
		model.addAttribute("titulo", "Lista de Autores");
		model.addAttribute("autores",autores);
		return "outros/autor/lista";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarAutor(
			@Valid @ModelAttribute Autor autor,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			autorRepository.save(autor);
		}
		
		model.addAttribute("autores",autorRepository.findAll());
		return "outros/autor/tabela-autores";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarAutor(@PathVariable Long id) {
		try {
			autorRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Autor buscarAutor(@PathVariable Long id){
		Autor autor = autorRepository.findOne(id);
		return autor;
	}
}
