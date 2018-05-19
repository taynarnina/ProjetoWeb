package br.edu.ufab.controller.pessoas;

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
import br.edu.ufab.model.entities.pessoas.Funcionario;
import br.edu.ufab.model.enums.NivelDeFuncionario;
import br.edu.ufab.model.repositories.pessoas.FuncionarioRepository;

/**
 * Classe responsável pelo controle das operações em Funcionario, manipulando os dados
 * no banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired private FuncionarioRepository funcionarioRepository;
	
	/**
	 * método que recebe os dados que estão no bd e mostra na tela a lista dos dados
	 * @param model
	 * */
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaFuncionario(Model model) {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		model.addAttribute("titulo", "Lista de Funcionarios");
		model.addAttribute("funcionarios",funcionarios);
		model.addAttribute("niveis",NivelDeFuncionario.values());
		return "pessoas/funcionario/lista";
	}
	
	/**
	 * método que recebe os dados que o usuário preencheu na tela
	 * e envia para o banco de dados.
	 * @param bindingResult,model
	 * */
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarFuncionario(
			@Valid @ModelAttribute Funcionario funcionario,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			funcionarioRepository.save(funcionario);
		}
		
		model.addAttribute("funcionarios",funcionarioRepository.findAll());
		return "pessoas/funcionario/tabela-funcionarios";
	}
	
	/**
	 * método que recebe o id do objeto que o usuário deseja deletar
	 * e apaga no banco de dados.
	 * @param id
	 * */
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarFuncionario(@PathVariable Long id) {
		try {
			funcionarioRepository.delete(id);
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
	public Funcionario buscarFuncionario(@PathVariable Long id){
		Funcionario funcionario = funcionarioRepository.findOne(id);
		return funcionario;
	}
}
