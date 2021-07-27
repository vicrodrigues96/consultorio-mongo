package br.com.meli.crudmongo.services;

import br.com.meli.crudmongo.dtos.TurnRequestDto;
import br.com.meli.crudmongo.entities.Doctor;
import br.com.meli.crudmongo.entities.Patient;
import br.com.meli.crudmongo.entities.Turn;
import br.com.meli.crudmongo.repositories.DoctorRepository;
import br.com.meli.crudmongo.repositories.PatientRepository;
import br.com.meli.crudmongo.repositories.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnService {

    private TurnRepository turnRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    @Autowired
    public TurnService(TurnRepository turnRepository,
                       DoctorRepository doctorRepository,
                       PatientRepository patientRepository) {
        this.turnRepository = turnRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public void persist(TurnRequestDto turnDto) throws Exception {
        Optional<Doctor> doctor = findDoctor(turnDto.getDoctorId());
        Optional<Patient> patient = findPatient(turnDto.getPatientId());

        Turn turn = new Turn(patient.get(), doctor.get(), turnDto.getDate(), turnDto.getStatus());

        this.turnRepository.save(turn);
    }

    public List<Turn> listTurns() {
        return this.turnRepository.findAll();
    }

    public List<Turn> listTurnsByDentist(String name) {
        return this.turnRepository.findAllByDoctor_FirstName(name);
    }

    public List<Turn> listTurnsByStatus(String status) {
        return this.turnRepository.findAllByStatus(status);
    }

    public void deleteTurnById(String id) {
        this.turnRepository.deleteById(id);
    }

    public Optional<Doctor> findDoctor(String id) throws Exception {
        Optional<Doctor> byId = this.doctorRepository.findById(id);

        if (byId.isEmpty()) {
            throw new Exception("Could not create a turn with an unexistent doctor!");
        }

        return byId;
    }

    public Optional<Patient> findPatient(String id) throws Exception {
        Optional<Patient> byId = this.patientRepository.findById(id);

        if (byId.isEmpty()) {
            throw new Exception("Could not create a turn with an unexistent patient!");
        }

        return byId;
    }
}
