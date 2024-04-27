package edu.miu.cs489.dentalappointment.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Patient extends User {
    @OneToOne
    @JoinColumn(name = "addressId")
    private Address mailingAddress;
    private LocalDate dob;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.MERGE)
    private List<Appointment> appointments;
}
