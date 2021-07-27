package br.com.meli.crudmongo.services;

import br.com.meli.crudmongo.entities.Patient;
import br.com.meli.crudmongo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void persist(Patient patient) {
        this.patientRepository.save(patient);
    }

    public List<Patient> listAllPatients() {
        return this.patientRepository.findAll();
    }

    public void deleteById(String id) {
        this.patientRepository.deleteById(id);
    }
}
