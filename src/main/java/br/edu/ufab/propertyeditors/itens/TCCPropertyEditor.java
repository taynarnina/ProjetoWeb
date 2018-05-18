package br.edu.ufab.propertyeditors.itens;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.itens.TCC;
import br.edu.ufab.model.repositories.itens.TCCRepository;

@Component
public class TCCPropertyEditor extends PropertyEditorSupport {

	@Autowired private TCCRepository tccRepository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idTCC = Long.parseLong(text);
		TCC tcc = tccRepository.findOne(idTCC);
		setValue(tcc);
	}
}
