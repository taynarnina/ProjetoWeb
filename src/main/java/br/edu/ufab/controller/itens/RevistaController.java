package br.edu.ufab.controller.itens;

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
import br.edu.ufab.model.entities.Editora;
import br.edu.ufab.model.entities.itens.Revista;
import br.edu.ufab.model.repositories.EditoraRepository;
import br.edu.ufab.model.repositories.itens.RevistaRepository;
import br.edu.ufab.propertyeditors.EditoraPropertyEditor;

@Controller
@RequestMapping("/revista")
public class RevistaController {
	
	@Autowired private EditoraPropertyEditor editoraPropertyEditor;
	@Autowired private EditoraRepository editoraRepository;
	@Autowired private RevistaRepository revistaRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaRevista(Model model) {
		Iterable<Revista> revistas = revistaRepository.findAll();
		model.addAttribute("titulo", "Lista de Revistas");
		model.addAttribute("revistas",revistas);
		model.addAttribute("editoras",editoraRepository.findAll());
		return "itens/revista/lista";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarRevista(
			@Valid @ModelAttribute Revista revista,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			revistaRepository.save(revista);
		}
		
		model.addAttribute("revistas",revistaRepository.findAll());
		model.addAttribute("editoras",editoraRepository.findAll());
		return "itens/revista/tabela-revistas";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarRevista(@PathVariable Long id) {
		try {
			revistaRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Revista buscarRevista(@PathVariable Long id){
		Revista revista = revistaRepository.findOne(id);
		return revista;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Editora.class, editoraPropertyEditor);
	}
}
