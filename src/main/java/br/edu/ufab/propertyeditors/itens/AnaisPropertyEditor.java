package br.edu.ufab.propertyeditors.itens;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.itens.Anais;
import br.edu.ufab.model.repositories.itens.AnaisRepository;
/**
 * Classe responsável por receber os dados completos de anais, procurar seu id e retornar seu nome,tipo e autor
 * para mapear em outra tabela.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
@Component
public class AnaisPropertyEditor extends PropertyEditorSupport {

	@Autowired private AnaisRepository anaisRepository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idAnais = Long.parseLong(text);
		Anais anais = anaisRepository.findOne(idAnais);
		setValue(anais);
	}	
}
