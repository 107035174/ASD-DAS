package edu.miu.cs489.dentalappointment.dto;

import java.time.LocalDate;
import java.util.List;

public record PatientDto(
        Integer patientId,
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        AddressDto mailingAddress,
        LocalDate dob,
        List<AppointmentDto> appointments) {
}
