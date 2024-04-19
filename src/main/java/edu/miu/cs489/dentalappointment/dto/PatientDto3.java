package edu.miu.cs489.dentalappointment.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto3 {
    private Integer patientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate dob;
}
