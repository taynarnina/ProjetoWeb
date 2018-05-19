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
import br.edu.ufab.model.entities.itens.Jornal;
import br.edu.ufab.model.repositories.EditoraRepository;
import br.edu.ufab.model.repositories.itens.JornalRepository;
import br.edu.ufab.propertyeditors.EditoraPropertyEditor;
/**
 * Classe responsável pelo controle das operações em Jornal, manipulando os dados
 * no banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
@Controller
@RequestMapping("/jornal")
public class JornalController {

	@Autowired private EditoraPropertyEditor editoraPropertyEditor;
	@Autowired private EditoraRepository editoraRepository;
	@Autowired private JornalRepository jornalRepository;
	
	/**
	 * método que recebe os dados que estão no bd e mostra na tela a lista dos dados
	 * @param model
	 * */
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaJornais(Model model) {
		Iterable<Jornal> jornais = jornalRepository.findAll();
		model.addAttribute("titulo", "Lista de Jornais");
		model.addAttribute("jornais",jornais);
		model.addAttribute("editoras",editoraRepository.findAll());
		return "itens/jornal/lista";
	}
	
	/**
	 * método que recebe os dados que o usuário preencheu na tela
	 * e envia para o banco de dados.
	 * @param bindingResult,model
	 * */
	
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
		return "itens/jornal/tabela-jornais";
	}
	/**
	 * método que recebe o id do objeto que o usuário deseja deletar
	 * e apaga no banco de dados.
	 * @param id
	 * */
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarJornal(@PathVariable Long id) {
		try {
			jornalRepository.delete(id);
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
	public Jornal buscarJornal(@PathVariable Long id){
		Jornal jornal = jornalRepository.findOne(id);
		return jornal;
	}
	
	/**
	 * método que recebe um objeto e pega o id para mapear na tabela desta classe.
	 * @param webDataBinder
	 * */
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Editora.class, editoraPropertyEditor);
	}
}
