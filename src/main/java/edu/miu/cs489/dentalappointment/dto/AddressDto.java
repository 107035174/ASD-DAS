package edu.miu.cs489.dentalappointment.dto;

public record AddressDto(
        Integer addressId,
        String street,
        String city,
        String state,
        String zip) {
}
