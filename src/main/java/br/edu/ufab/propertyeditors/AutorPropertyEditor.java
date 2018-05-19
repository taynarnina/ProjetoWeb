package br.edu.ufab.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.Autor;
import br.edu.ufab.model.repositories.AutorRepository;

/**
 * Classe responsável por receber os dados completos de Autor, procurar sue id e retornar seu nome
 * para mapear em outra tabela.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */

@Component
public class AutorPropertyEditor extends PropertyEditorSupport {

	@Autowired private AutorRepository autorRepository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idAutor = Long.parseLong(text);
		Autor autor = autorRepository.findOne(idAutor);
		setValue(autor);
	}	
}
