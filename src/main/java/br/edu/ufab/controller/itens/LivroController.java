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
import br.edu.ufab.model.entities.Autor;
import br.edu.ufab.model.entities.Editora;
import br.edu.ufab.model.entities.itens.Livro;
import br.edu.ufab.model.repositories.AutorRepository;
import br.edu.ufab.model.repositories.EditoraRepository;
import br.edu.ufab.model.repositories.itens.LivroRepository;
import br.edu.ufab.propertyeditors.AutorPropertyEditor;
import br.edu.ufab.propertyeditors.EditoraPropertyEditor;

@Controller
@RequestMapping("/livro")
public class LivroController {

	@Autowired private EditoraPropertyEditor editoraPropertyEditor;
	@Autowired private EditoraRepository editoraRepository;
	@Autowired private AutorPropertyEditor autorPropertyEditor;
	@Autowired private AutorRepository autorRepository;
	@Autowired private LivroRepository livroRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaLivros(Model model) {
		Iterable<Livro> livros = livroRepository.findAll();
		model.addAttribute("titulo", "Lista de Livros");
		model.addAttribute("livros",livros);
		model.addAttribute("editoras",editoraRepository.findAll());
		model.addAttribute("autores",autorRepository.findAll());
		return "itens/livro/lista";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarLivro(
			@Valid @ModelAttribute Livro livro,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			livroRepository.save(livro);
		}
		
		model.addAttribute("livros",livroRepository.findAll());
		model.addAttribute("editoras",editoraRepository.findAll());
		model.addAttribute("autores",autorRepository.findAll());
		return "itens/livro/tabela-livros";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarLivro(@PathVariable Long id) {
		try {
			livroRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Livro buscarLivro(@PathVariable Long id){
		Livro livro = livroRepository.findOne(id);
		return livro;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Editora.class, editoraPropertyEditor);
		webDataBinder.registerCustomEditor(Autor.class, autorPropertyEditor);
	}
}
