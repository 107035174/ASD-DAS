package edu.miu.cs489.dentalappointment.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime scheduledDate;
    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "surgeryId")
    private Surgery surgery;
    @ManyToOne
    @JoinColumn(name = "dentistId")
    private Dentist dentist;
}
