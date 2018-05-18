package br.edu.ufab.propertyeditors.itens;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.itens.Jornal;
import br.edu.ufab.model.repositories.itens.JornalRepository;

@Component
public class JornalPropertyEditor extends PropertyEditorSupport {

	@Autowired private JornalRepository jornalRepository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idJornal = Long.parseLong(text);
		Jornal jornal = jornalRepository.findOne(idJornal);
		setValue(jornal);
	}	
}
