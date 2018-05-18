package br.edu.ufab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ufab.model.entities.Emprestimo;
import br.edu.ufab.model.repositories.EmprestimoRepository;

@Controller
@RequestMapping("/divida")
public class DividaController {
	
	@Autowired EmprestimoRepository emprestimoRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarEmprestimoComDivida(Model model) {
		Iterable<Emprestimo> emprestimos = emprestimoRepository.findAll();
		model.addAttribute("titulo", "Lista de Alunos com Divida");
		model.addAttribute("emprestimos",emprestimos);
		return "divida/lista";
	}

}
