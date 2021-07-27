package br.com.meli.crudmongo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Doctor {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String specialty;
}
