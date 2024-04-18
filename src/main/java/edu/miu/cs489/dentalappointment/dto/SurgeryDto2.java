package edu.miu.cs489.dentalappointment.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SurgeryDto2 {
    private Integer surgeryId;
    private String name;
    private String phoneNumber;
    private AddressDto address;
    private List<AppointmentDto> appointments;
}
