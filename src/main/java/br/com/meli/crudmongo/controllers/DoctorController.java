package br.com.meli.crudmongo.controllers;

import br.com.meli.crudmongo.entities.Doctor;
import br.com.meli.crudmongo.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultorio/doctors")
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void persist(@RequestBody Doctor doctor) {
        this.doctorService.persist(doctor);
    }

    @GetMapping
    public List<Doctor> listAllDoctors() {
        return this.doctorService.listAllDoctors();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        this.doctorService.deleteById(id);
    }
}
