package br.edu.ufab.controller;

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
import br.edu.ufab.model.entities.Curso;
import br.edu.ufab.model.enums.AreaDeCurso;
import br.edu.ufab.model.enums.TipoDeCurso;
import br.edu.ufab.model.repositories.CursoRepository;
/**
 * Classe responsável pelo controle das operações em Curso, manipulando os dados
 * no banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired private CursoRepository cursoRepository;
	/**
	 * método que recebe os dados que estão no bd e mostra na tela a lista dos dados
	 * @param model
	 * */
	@RequestMapping(method=RequestMethod.GET)
	public String listaCursos(Model model) {
		Iterable<Curso> cursos = cursoRepository.findAll();
		model.addAttribute("titulo", "Lista de Cursos");
		model.addAttribute("cursos",cursos);
		model.addAttribute("areas",AreaDeCurso.values());
		model.addAttribute("tipos",TipoDeCurso.values());
		return "outros/curso/lista";
	}
	/**
	 * método que recebe os dados que o usuário preencheu na tela
	 * e envia para o banco de dados.
	 * @param bindingResult,model
	 * */
	@RequestMapping(method=RequestMethod.POST)
	public String salvarCurso(
			@Valid @ModelAttribute Curso curso,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			cursoRepository.save(curso);
		}
		
		model.addAttribute("cursos",cursoRepository.findAll());
		return "outros/curso/tabela-cursos";
	}
	/**
	 * método que recebe o id do objeto que o usuário deseja deletar
	 * e apaga no banco de dados.
	 * @param id
	 * */
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarCurso(@PathVariable Long id) {
		try {
			cursoRepository.delete(id);
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
	public Curso buscarCurso(@PathVariable Long id){
		Curso curso = cursoRepository.findOne(id);
		return curso;
	}
}
