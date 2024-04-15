package edu.miu.cs489.dentalappointment.dto;

import java.time.LocalDateTime;

public record AppointmentDto(
        Integer appointmentId,
        LocalDateTime createdDateTime,
        LocalDateTime scheduledDateTime) {
}
