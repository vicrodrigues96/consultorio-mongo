package br.com.meli.crudmongo.repositories;

import br.com.meli.crudmongo.entities.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {

    void deleteById(String id);
}
