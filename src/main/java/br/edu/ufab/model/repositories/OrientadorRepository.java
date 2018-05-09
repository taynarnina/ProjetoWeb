package br.edu.ufab.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufab.model.entities.Orientador;

@Repository
public interface OrientadorRepository extends CrudRepository<Orientador, Long> {

}
