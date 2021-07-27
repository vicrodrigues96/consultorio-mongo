package br.com.meli.crudmongo.repositories;

import br.com.meli.crudmongo.entities.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository <Doctor, String>{

    void deleteById(String id);
}
