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
/**
 * Classe respons�vel pelo controle das opera��es em Revistas, manipulando os dados
 * no banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
@Controller
@RequestMapping("/revista")
public class RevistaController {
	
	@Autowired private EditoraPropertyEditor editoraPropertyEditor;
	@Autowired private EditoraRepository editoraRepository;
	@Autowired private RevistaRepository revistaRepository;
	
	/**
	 * m�todo que recebe os dados que est�o no bd e mostra na tela a lista dos dados
	 * @param model
	 * */
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaRevista(Model model) {
		Iterable<Revista> revistas = revistaRepository.findAll();
		model.addAttribute("titulo", "Lista de Revistas");
		model.addAttribute("revistas",revistas);
		model.addAttribute("editoras",editoraRepository.findAll());
		return "itens/revista/lista";
	}
	
	/**
	 * m�todo que recebe os dados que o usu�rio preencheu na tela
	 * e envia para o banco de dados.
	 * @param bindingResult,model
	 * */
	
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
		return "itens/revista/tabela-revistas";
	}
	
	/**
	 * m�todo que recebe o id do objeto que o usu�rio deseja deletar
	 * e apaga no banco de dados.
	 * @param id
	 * */
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarRevista(@PathVariable Long id) {
		try {
			revistaRepository.delete(id);
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
	public Revista buscarRevista(@PathVariable Long id){
		Revista revista = revistaRepository.findOne(id);
		return revista;
	}
	
	/**
	 * m�todo que recebe um objeto e pega o id para mapear na tabela desta classe.
	 * @param webDataBinder
	 * */
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Editora.class, editoraPropertyEditor);
	}
}
