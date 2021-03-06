package br.edu.ufab.model.repositories.pessoas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufab.model.entities.pessoas.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

}
