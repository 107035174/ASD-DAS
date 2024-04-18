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
public class PatientDto {
        private Integer patientId;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;
        private AddressDto mailingAddress;
        private LocalDate dob;
        private List<AppointmentDto> appointments;
}
