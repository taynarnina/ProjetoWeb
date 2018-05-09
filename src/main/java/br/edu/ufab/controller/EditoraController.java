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
import br.edu.ufab.model.entities.Editora;
import br.edu.ufab.model.repositories.EditoraRepository;

@Controller
@RequestMapping("/editora")
public class EditoraController {

	@Autowired private EditoraRepository editoraRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaEditoras(Model model) {
		Iterable<Editora> editoras = editoraRepository.findAll();
		model.addAttribute("titulo", "Lista de Editoras");
		model.addAttribute("editoras",editoras);
		return "editora/lista";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarEditora(
			@Valid @ModelAttribute Editora editora,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			editoraRepository.save(editora);
		}
		
		model.addAttribute("editoras",editoraRepository.findAll());
		return "editora/tabela-editoras";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarEditora(@PathVariable Long id) {
		try {
			editoraRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Editora buscarEditora(@PathVariable Long id){
		Editora editora = editoraRepository.findOne(id);
		return editora;
	}	
}
