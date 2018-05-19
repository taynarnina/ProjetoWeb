package br.edu.ufab.propertyeditors.itens;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.itens.TCC;
import br.edu.ufab.model.repositories.itens.TCCRepository;
/**
 * Classe responsável por receber os dados completos de Autor, procurar seu id e retornar seu titulo,orientador,etc.,
 * para mapear em outra tabela.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
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
