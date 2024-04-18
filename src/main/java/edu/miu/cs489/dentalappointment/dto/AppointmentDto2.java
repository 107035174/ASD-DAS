package edu.miu.cs489.dentalappointment.dto;

import java.time.LocalDateTime;

public record AppointmentDto2(
                Integer appointmentId,
                LocalDateTime createdDateTime,
                LocalDateTime scheduledDateTime,
                DentistDto2 dentist,
                PatientDto2 patient,
                SurgeryDto2 surgery) {
}
