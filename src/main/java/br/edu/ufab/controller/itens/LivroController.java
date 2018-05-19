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

/**
 * Classe respons�vel pelo controle das opera��es em Livro, manipulando os dados
 * no banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */

@Controller
@RequestMapping("/livro")
public class LivroController {

	@Autowired private EditoraPropertyEditor editoraPropertyEditor;
	@Autowired private EditoraRepository editoraRepository;
	@Autowired private AutorPropertyEditor autorPropertyEditor;
	@Autowired private AutorRepository autorRepository;
	@Autowired private LivroRepository livroRepository;
	
	/**
	 * m�todo que recebe os dados que est�o no bd e mostra na tela a lista dos dados
	 * @param model
	 * */
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaLivros(Model model) {
		Iterable<Livro> livros = livroRepository.findAll();
		model.addAttribute("titulo", "Lista de Livros");
		model.addAttribute("livros",livros);
		model.addAttribute("editoras",editoraRepository.findAll());
		model.addAttribute("autores",autorRepository.findAll());
		return "itens/livro/lista";
	}
	
	/**
	 * m�todo que recebe os dados que o usu�rio preencheu na tela
	 * e envia para o banco de dados.
	 * @param bindingResult,model
	 * */
	
	
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
		return "itens/livro/tabela-livros";
	}
	
	/**
	 * m�todo que recebe o id do objeto que o usu�rio deseja deletar
	 * e apaga no banco de dados.
	 * @param id
	 * */
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarLivro(@PathVariable Long id) {
		try {
			livroRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * m�todo que recebe o id do objeto que o usu�rio deseja 
	 * e apresenta na tela.
	 * @param id
	 * */
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Livro buscarLivro(@PathVariable Long id){
		Livro livro = livroRepository.findOne(id);
		return livro;
	}
	
	/**
	 * m�todo que recebe um objeto e pega o id para mapear na tabela desta classe.
	 * @param webDataBinder
	 * */
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Editora.class, editoraPropertyEditor);
		webDataBinder.registerCustomEditor(Autor.class, autorPropertyEditor);
	}
}
