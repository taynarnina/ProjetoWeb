package br.edu.ufab.model.repositories.itens;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufab.model.entities.itens.TCC;

@Repository
public interface TCCRepository extends CrudRepository<TCC, Long> {

}
