package br.edu.ufab.controller.pessoas;

import java.util.Random;

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
import br.edu.ufab.model.entities.Curso;
import br.edu.ufab.model.entities.pessoas.Aluno;
import br.edu.ufab.model.enums.PeriodoDeIngresso;
import br.edu.ufab.model.enums.TipoDeCurso;
import br.edu.ufab.model.repositories.CursoRepository;
import br.edu.ufab.model.repositories.pessoas.AlunoRepository;
import br.edu.ufab.propertyeditors.CursoPropertyEditor;

/**
 * Classe respons�vel pelo controle das opera��es em Aluno, manipulando os dados
 * no banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired private CursoPropertyEditor cursoPropertyEditor;
	@Autowired private CursoRepository cursoRepository;
	@Autowired private AlunoRepository alunoRepository;
	
	/**
	 * m�todo que recebe os dados que est�o no bd e mostra na tela a lista dos dados
	 * @param model
	 * */
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String listaAlunos(Model model) {
		Iterable<Aluno> alunos = alunoRepository.findAll();
		model.addAttribute("titulo", "Lista de Alunos");
		model.addAttribute("alunos",alunos);
		model.addAttribute("periodos",PeriodoDeIngresso.values());
		model.addAttribute("cursos",cursoRepository.findAll());
		return "pessoas/aluno/lista";
	}
	
	/**
	 * m�todo que recebe os dados que o usu�rio preencheu na tela
	 * e envia para o banco de dados. Tamb�m � gerada a matr�cula do  aluno
	 * @param bindingResult,model
	 * */
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarAluno(
			@Valid @ModelAttribute Aluno aluno,
			BindingResult bindingResult,
			Model model) {
		
		if ( bindingResult.hasErrors() ) {
			throw new Exception();
		} else {
			
			//Monta matricua
			Curso curso = aluno.getCurso();
			TipoDeCurso tipo = curso.getTipo();
			String codigo = curso.getCodigo();
			String anointeiro = String.valueOf(aluno.getAno());
			String ano = anointeiro.substring(2,4);
			
			PeriodoDeIngresso periodoenum = aluno.getPeriodo();
			String periodo = "";
			if(periodoenum.toString() == "PRIMEIRO") {
				periodo = "1";
			} else {
				periodo = "2";
			}
			
			Random gerador = new Random();
			int aux = gerador.nextInt(1000);
			
			String num = Integer.toString(aux);
			
			String id = "";
			if(num.length() == 1) {
				id = "00"+num;
			} else if (num.length() == 2) {
				id = "0"+num;
			} else {
				id = num;
			}
			
			String matricula = tipo+codigo+"-"+ano+periodo+id;
			aluno.setMatricula(matricula);
			
			alunoRepository.save(aluno);
		}
		
		model.addAttribute("alunos",alunoRepository.findAll());
		return "pessoas/aluno/tabela-alunos";
	}
	
	/**
	 * m�todo que recebe o id do objeto que o usu�rio deseja deletar
	 * e apaga no banco de dados.
	 * @param id
	 * */
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarAluno(@PathVariable Long id) {
		try {
			alunoRepository.delete(id);
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
	public Aluno buscarAluno(@PathVariable Long id){
		Aluno aluno = alunoRepository.findOne(id);
		return aluno;
	}
	
	/**
	 * m�todo que recebe um objeto e pega o id para mapear na tabela desta classe.
	 * @param webDataBinder
	 * */
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Curso.class, cursoPropertyEditor);
	}
}
