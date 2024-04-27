package edu.miu.cs489.dentalappointment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DentistDto {
        private Integer userId;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;
        private String specialization;
}
