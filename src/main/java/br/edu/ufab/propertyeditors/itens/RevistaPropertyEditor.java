package br.edu.ufab.propertyeditors.itens;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.itens.Revista;
import br.edu.ufab.model.repositories.itens.RevistaRepository;

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
