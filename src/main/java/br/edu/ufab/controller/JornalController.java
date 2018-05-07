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
import br.edu.ufab.model.entities.itens.Jornal;
import br.edu.ufab.model.repositories.itens.JornalRepository;

@Controller
@RequestMapping("/jornal")
public class JornalController {

	@Autowired private JornalRepository jornalRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaJornais(Model model) {
		Iterable<Jornal> jornais = jornalRepository.findAll();
		model.addAttribute("titulo", "Lista de Jornais");
		model.addAttribute("jornais",jornais);
		return "jornal/lista";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarJornal(
			@Valid @ModelAttribute Jornal jornal,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			jornalRepository.save(jornal);
		}
		
		model.addAttribute("jornais",jornalRepository.findAll());
		return "jornal/tabela-jornais";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarJornal(@PathVariable Long id) {
		try {
			jornalRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Jornal buscarJornal(@PathVariable Long id){
		Jornal jornal = jornalRepository.findOne(id);
		return jornal;
	}
}
