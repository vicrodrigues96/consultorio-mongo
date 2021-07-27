package br.com.meli.crudmongo.repositories;

import br.com.meli.crudmongo.entities.Turn;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TurnRepository extends MongoRepository<Turn, String> {

    List<Turn> findAllByDoctor_FirstName(String name);
    List<Turn> findAllByStatus(String status);
    void deleteById(String id);
}
