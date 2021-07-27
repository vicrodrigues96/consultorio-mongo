package br.com.meli.crudmongo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "turns")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Turn {

    @Id
    private String id;
    @Field(name = "patients")
    private Patient patient;
    @Field(name = "doctors")
    private Doctor doctor;
    private LocalDate date;
    private String status;

    public Turn(Patient patient, Doctor doctor, LocalDate date, String status) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = status;
    }
}
