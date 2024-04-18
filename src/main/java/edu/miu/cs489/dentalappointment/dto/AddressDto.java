package edu.miu.cs489.dentalappointment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
        private Integer addressId;
        private String street;
        private String city;
        private String state;
        private String zip;
}
