package br.com.meli.crudmongo.controllers;

import br.com.meli.crudmongo.entities.Patient;
import br.com.meli.crudmongo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultorio/patients")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void persist(@RequestBody Patient patient) {
        this.patientService.persist(patient);
    }

    @GetMapping()
    public List<Patient> listAllPatients() {
        return this.patientService.listAllPatients();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        this.patientService.deleteById(id);
    }
}
