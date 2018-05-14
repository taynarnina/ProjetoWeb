package br.edu.ufab.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufab.model.entities.FichaDeEmprestimo;

@Repository
public interface FichaDeEmprestimoRepository extends CrudRepository<FichaDeEmprestimo, Long> {

}
