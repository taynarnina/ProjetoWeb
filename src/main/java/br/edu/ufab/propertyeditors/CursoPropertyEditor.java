package br.edu.ufab.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.Curso;
import br.edu.ufab.model.repositories.CursoRepository;

/**
 * Classe responsável por receber os dados completos de Curso, procurar sue id e retornar seu nome,tipo,código e área
 * para mapear em outra tabela.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */

@Component
public class CursoPropertyEditor extends PropertyEditorSupport {

	@Autowired private CursoRepository cursoRepository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idCurso = Long.parseLong(text);
		Curso curso = cursoRepository.findOne(idCurso);
		setValue(curso);
	}
}
