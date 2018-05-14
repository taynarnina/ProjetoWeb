package br.edu.ufab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ufab.model.repositories.itens.AnaisRepository;
//import br.edu.ufab.model.repositories.itens.JornalRepository;
//import br.edu.ufab.model.repositories.FichaDeEmprestimoRepository;
import br.edu.ufab.model.repositories.pessoas.AlunoRepository;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {
	
	@Autowired private AlunoRepository alunoRepository;
	@Autowired private AnaisRepository anaisRepository;
	//@Autowired private JornalRepository jornalRepository;
	//@Autowired private FichaDeEmprestimoRepository fichaDeEmprestimoRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String novoEmprestimo(Model model) {
		model.addAttribute("titulo", "Novo Emprestimo");
		model.addAttribute("alunos",alunoRepository.findAll());
		
		//model.addAttribute("jornais",jornalRepository.findAll());
		return "emprestimo/novo-emprestimo";
	}
	
	@RequestMapping("/anais")
	public String novoAnais(Model model) {
		model.addAttribute("titulo", "Novo Emprestimo de Anais");
		model.addAttribute("anais",anaisRepository.findAll());
		return "emprestimo/anais-emprestimo";
	}

}
