package edu.miu.cs489.dentalappointment.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @OneToOne
    @JoinColumn(name = "addressId")
    private Address mailingAddress;
    private LocalDate dob;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.MERGE)
    private List<Appointment> appointments;
}
