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
import br.edu.ufab.model.entities.itens.Anais;
import br.edu.ufab.model.enums.TipoDeAnais;
import br.edu.ufab.model.repositories.AutorRepository;
import br.edu.ufab.model.repositories.itens.AnaisRepository;
import br.edu.ufab.propertyeditors.AutorPropertyEditor;
/**
 * Classe responsável pelo controle das operações em Anais, manipulando os dados
 * no banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
@Controller
@RequestMapping("/anais")
public class AnaisController {

	@Autowired private AutorPropertyEditor autorPropertyEditor;
	@Autowired private AutorRepository autorRepository;
	@Autowired private AnaisRepository anaisRepository;
	
	/**
	 * método que recebe os dados que estão no bd e mostra na tela a lista dos dados
	 * @param model
	 * */
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaAnais(Model model) {
		Iterable<Anais> anais = anaisRepository.findAll();
		model.addAttribute("titulo", "Lista de Anais");
		model.addAttribute("anais",anais);
		model.addAttribute("tipos",TipoDeAnais.values());
		model.addAttribute("autores",autorRepository.findAll());
		return "itens/anais/lista";
	}
	
	/**
	 * método que recebe os dados que o usuário preencheu na tela
	 * e envia para o banco de dados.
	 * @param bindingResult,model
	 * */
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarAnais(
			@Valid @ModelAttribute Anais anais,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			anaisRepository.save(anais);
		}
		
		model.addAttribute("anais",anaisRepository.findAll());
		return "itens/anais/tabela-anais";
	}
	
	/**
	 * método que recebe o id do objeto que o usuário deseja deletar
	 * e apaga no banco de dados.
	 * @param id
	 * */
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarAnais(@PathVariable Long id) {
		try {
			anaisRepository.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * método que recebe o id do objeto que o usuário deseja 
	 * e apresenta na tela.
	 * @param id
	 * */
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Anais buscarAnais(@PathVariable Long id){
		Anais anais = anaisRepository.findOne(id);
		return anais;
	}
	/**
	 * método que recebe um objeto e pega o id para mapear na tabela desta classe.
	 * @param webDataBinder
	 * */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Autor.class, autorPropertyEditor);
	}	
}
