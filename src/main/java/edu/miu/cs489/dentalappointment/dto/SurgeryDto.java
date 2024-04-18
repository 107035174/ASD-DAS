package edu.miu.cs489.dentalappointment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SurgeryDto {
    private Integer surgeryId;
    private String name;
    private String phoneNumber;
    private AddressDto address;
}
