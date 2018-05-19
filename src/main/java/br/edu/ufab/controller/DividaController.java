package br.edu.ufab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ufab.model.entities.Emprestimo;
import br.edu.ufab.model.repositories.EmprestimoRepository;

/**
 * Classe responsável pelo controle das operações em Divida, manipulando os dados
 * no banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */

@Controller
@RequestMapping("/divida")
public class DividaController {
	
	@Autowired EmprestimoRepository emprestimoRepository;
	/**
	 * método que recebe os dados que estão no bd e mostra na tela a lista dos dados
	 * @param model
	 * */
	@RequestMapping(method=RequestMethod.GET)
	public String listarEmprestimoComDivida(Model model) {
		Iterable<Emprestimo> emprestimos = emprestimoRepository.findAll();
		model.addAttribute("titulo", "Lista de Alunos com Divida");
		model.addAttribute("emprestimos",emprestimos);
		return "divida/lista";
	}

}
