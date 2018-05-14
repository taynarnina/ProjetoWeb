package br.edu.ufab.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufab.model.entities.Editora;

@Repository
public interface EditoraRepository extends CrudRepository <Editora, Long> {

}
