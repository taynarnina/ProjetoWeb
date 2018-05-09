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
import br.edu.ufab.model.entities.Orientador;
import br.edu.ufab.model.repositories.OrientadorRepository;

@Controller
@RequestMapping("/orientador")
public class OrientadorController {

	@Autowired private OrientadorRepository orientadorRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaOrientadores(Model model) {
		Iterable<Orientador> orientadores = orientadorRepository.findAll();
		model.addAttribute("titulo", "Lista de Orientadores");
		model.addAttribute("orientadores",orientadores);
		return "orientador/lista";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarOrientador(
			@Valid @ModelAttribute Orientador orientador,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			orientadorRepository.save(orientador);
		}
		
		model.addAttribute("orientadores",orientadorRepository.findAll());
		return "orientador/tabela-orientadores";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarOrientador(@PathVariable Long id) {
		try {
			orientadorRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Orientador buscarOrientador(@PathVariable Long id){
		Orientador orientador = orientadorRepository.findOne(id);
		return orientador;
	}
}
