package edu.miu.cs489.dentalappointment.dto;

import java.util.List;

public record DentistDto(
        Integer dentistId,
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String specialization,
        List<AppointmentDto> appointments) {
}
