package br.com.meli.crudmongo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnRequestDto {

    private String patientId;
    private String doctorId;
    private LocalDate date;
    private String status;
}
