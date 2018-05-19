package br.edu.ufab.controller.itens;

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
import br.edu.ufab.model.entities.itens.MidiaEletronica;
import br.edu.ufab.model.enums.TipoDeMidia;
import br.edu.ufab.model.repositories.itens.MidiaEletronicaRepository;
/**
 * Classe responsável pelo controle das operações em MidiaEletronica, manipulando os dados
 * no banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
@Controller
@RequestMapping("/midia")
public class MidiaEletronicaController {
	
	@Autowired private MidiaEletronicaRepository midiaEletronicaRepository;
	/**
	 * método que recebe os dados que estão no bd e mostra na tela a lista dos dados
	 * @param model
	 * */
	@RequestMapping(method=RequestMethod.GET)
	public String listaMidias(Model model) {
		Iterable<MidiaEletronica> midias = midiaEletronicaRepository.findAll();
		model.addAttribute("titulo", "Lista de Midias Eletronicas");
		model.addAttribute("midias",midias);
		model.addAttribute("tipos",TipoDeMidia.values());
		return "itens/midia/lista";
	}
	/**
	 * método que recebe os dados que o usuário preencheu na tela
	 * e envia para o banco de dados.
	 * @param bindingResult,model
	 * */
	@RequestMapping(method=RequestMethod.POST)
	public String salvarMidia(
			@Valid @ModelAttribute MidiaEletronica midiaEletronica,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			midiaEletronicaRepository.save(midiaEletronica);
		}
		
		model.addAttribute("midias",midiaEletronicaRepository.findAll());
		return "itens/midia/tabela-midias";
	}
	
	/**
	 * método que recebe o id do objeto que o usuário deseja deletar
	 * e apaga no banco de dados.
	 * @param id
	 * */
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarMidia(@PathVariable Long id) {
		try {
			midiaEletronicaRepository.delete(id);
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
	public MidiaEletronica buscarMidia(@PathVariable Long id){
		MidiaEletronica midia = midiaEletronicaRepository.findOne(id);
		return midia;
	}
}
