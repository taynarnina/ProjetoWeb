package br.edu.ufab.propertyeditors.itens;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.itens.Anais;
import br.edu.ufab.model.repositories.itens.AnaisRepository;

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
