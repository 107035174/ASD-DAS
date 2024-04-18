package edu.miu.cs489.dentalappointment.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto2 {
    private Integer appointmentId;
    private LocalDateTime createdDateTime;
    private LocalDateTime scheduledDateTime;
    private DentistDto dentist;
    private PatientDto patient;
    private SurgeryDto surgery;
}
