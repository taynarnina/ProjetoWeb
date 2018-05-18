package br.edu.ufab.propertyeditors.pessoas;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufab.model.entities.pessoas.Aluno;
import br.edu.ufab.model.repositories.pessoas.AlunoRepository;

@Component
public class AlunoPropertyEditor extends PropertyEditorSupport {

	@Autowired private AlunoRepository alunoRepository;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idAluno = Long.parseLong(text);
		Aluno aluno = alunoRepository.findOne(idAluno);
		setValue(aluno);
	}
}
