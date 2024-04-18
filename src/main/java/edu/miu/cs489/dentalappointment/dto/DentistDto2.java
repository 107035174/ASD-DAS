package edu.miu.cs489.dentalappointment.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DentistDto2 {
    private Integer dentistId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String specialization;
    private List<AppointmentDto> appointments;
}
