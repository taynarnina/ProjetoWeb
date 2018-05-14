package br.edu.ufab.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.Autor;
import br.edu.ufab.model.repositories.AutorRepository;

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
