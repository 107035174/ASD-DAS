package edu.miu.cs489.dentalappointment.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dentistId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String specialization;
    @OneToMany(mappedBy = "dentist", cascade = CascadeType.MERGE)
    private List<Appointment> appointments;
}
