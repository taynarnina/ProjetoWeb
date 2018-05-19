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
import br.edu.ufab.model.entities.Orientador;
import br.edu.ufab.model.entities.itens.TCC;
import br.edu.ufab.model.enums.TipoDeTCC;
import br.edu.ufab.model.repositories.AutorRepository;
import br.edu.ufab.model.repositories.OrientadorRepository;
import br.edu.ufab.model.repositories.itens.TCCRepository;
import br.edu.ufab.propertyeditors.AutorPropertyEditor;
import br.edu.ufab.propertyeditors.OrientadorPropertyEditor;
/**
 * Classe responsável pelo controle das operações em Tcc, manipulando os dados
 * no banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
@Controller
@RequestMapping("/tcc")
public class TCCController {
	
	@Autowired private AutorPropertyEditor autorPropertyEditor;
	@Autowired private AutorRepository autorRepository;
	@Autowired private OrientadorPropertyEditor orientadorPropertyEditor;
	@Autowired private OrientadorRepository oriendadorRepository;
	@Autowired private TCCRepository tccRepository;
	
	/**
	 * método que recebe os dados que estão no bd e mostra na tela a lista dos dados
	 * @param model
	 * */
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaTCC(Model model) {
		Iterable<TCC> tccs = tccRepository.findAll();
		model.addAttribute("titulo", "Lista de TCC");
		model.addAttribute("tccs",tccs);
		model.addAttribute("tipos",TipoDeTCC.values());
		model.addAttribute("autores",autorRepository.findAll());
		model.addAttribute("orientadores",oriendadorRepository.findAll());
		return "itens/tcc/lista";
	}
	
	/**
	 * método que recebe os dados que o usuário preencheu na tela
	 * e envia para o banco de dados.
	 * @param bindingResult,model
	 * */
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarTCC(
			@Valid @ModelAttribute TCC tcc,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			tccRepository.save(tcc);
		}
		
		model.addAttribute("tccs",tccRepository.findAll());
		return "itens/tcc/tabela-tccs";
	}
	
	/**
	 * método que recebe o id do objeto que o usuário deseja deletar
	 * e apaga no banco de dados.
	 * @param id
	 * */
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarTCC(@PathVariable Long id) {
		try {
			tccRepository.delete(id);
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
	public TCC buscarTCC(@PathVariable Long id){
		TCC tcc = tccRepository.findOne(id);
		return tcc;
	}
	/**
	 * método que recebe um objeto e pega o id para mapear na tabela desta classe.
	 * @param webDataBinder
	 * */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Autor.class, autorPropertyEditor);
		webDataBinder.registerCustomEditor(Orientador.class, orientadorPropertyEditor);
	}
}
