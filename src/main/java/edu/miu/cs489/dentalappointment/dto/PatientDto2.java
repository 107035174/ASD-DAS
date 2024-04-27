package edu.miu.cs489.dentalappointment.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto2 {
    private Integer userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private AddressDto mailingAddress;
    private LocalDate dob;
    private List<AppointmentDto> appointments;
}
