package edu.miu.cs489.dentalappointment.dto;

import java.util.List;

public record SurgeryDto(
        Integer surgeryId,
        String name,
        String phoneNumber,
        AddressDto address,
        List<AppointmentDto> appointments) {
}
