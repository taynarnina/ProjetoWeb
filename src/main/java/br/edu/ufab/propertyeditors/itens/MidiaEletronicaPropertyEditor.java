package br.edu.ufab.propertyeditors.itens;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.itens.MidiaEletronica;
import br.edu.ufab.model.repositories.itens.MidiaEletronicaRepository;

@Component
public class MidiaEletronicaPropertyEditor extends PropertyEditorSupport {

	@Autowired private MidiaEletronicaRepository midiaEletronicaRepository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idMidia = Long.parseLong(text);
		MidiaEletronica midia = midiaEletronicaRepository.findOne(idMidia);
		setValue(midia);
	}	
}
