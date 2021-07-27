package br.com.meli.crudmongo.services;

import br.com.meli.crudmongo.entities.Doctor;
import br.com.meli.crudmongo.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void persist(Doctor doctor) {
        this.doctorRepository.save(doctor);
    }

    public List<Doctor> listAllDoctors() {
        return this.doctorRepository.findAll();
    }

    public void deleteById(String id) {
        this.doctorRepository.deleteById(id);
    }
}
