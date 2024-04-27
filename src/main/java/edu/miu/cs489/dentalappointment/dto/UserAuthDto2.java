package edu.miu.cs489.dentalappointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthDto2 {
    private String jwToken;
    private String username;
    private String password;
}
