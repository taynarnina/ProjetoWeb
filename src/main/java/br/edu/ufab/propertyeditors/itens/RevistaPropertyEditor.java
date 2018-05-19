package br.edu.ufab.propertyeditors.itens;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.itens.Revista;
import br.edu.ufab.model.repositories.itens.RevistaRepository;
/**
 * Classe responsável por receber os dados completos de revista, procurar seu id e retornar seu titulo,editora,etc.,
 * para mapear em outra tabela.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
@Component
public class RevistaPropertyEditor extends PropertyEditorSupport {

	@Autowired private RevistaRepository revistaRepository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idRevista = Long.parseLong(text);
		Revista revista = revistaRepository.findOne(idRevista);
		setValue(revista);
	}
}
