package br.edu.ufab.propertyeditors.itens;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.itens.Livro;
import br.edu.ufab.model.repositories.itens.LivroRepository;

@Component
public class LivroPropertyEditor extends PropertyEditorSupport {

	@Autowired private LivroRepository livroRepository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idLivro = Long.parseLong(text);
		Livro livro = livroRepository.findOne(idLivro);
		setValue(livro);
	}
}
