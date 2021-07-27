package br.com.meli.crudmongo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patients")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
}
