package br.edu.ufab.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.Editora;
import br.edu.ufab.model.repositories.EditoraRepository;

/**
 * Classe respons�vel por receber os dados completos de editora, procurar seu id e retornar seu nome
 * para mapear em outra tabela.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */

@Component
public class EditoraPropertyEditor extends PropertyEditorSupport {

	@Autowired private EditoraRepository editoraRepository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idEditora = Long.parseLong(text);
		Editora editora = editoraRepository.findOne(idEditora);
		setValue(editora);
	}
}
