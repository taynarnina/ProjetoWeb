package br.edu.ufab.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.Orientador;
import br.edu.ufab.model.repositories.OrientadorRepository;

@Component
public class OrientadorPropertyEditor extends PropertyEditorSupport {

	@Autowired private OrientadorRepository orientadorRepository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idOrientador = Long.parseLong(text);
		Orientador orientador = orientadorRepository.findOne(idOrientador);
		setValue(orientador);
	}	
}
