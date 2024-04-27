package edu.miu.cs489.dentalappointment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.dentalappointment.dto.UserAuthDto;
import edu.miu.cs489.dentalappointment.dto.UserAuthDto2;
import edu.miu.cs489.dentalappointment.service.UserService;
import edu.miu.cs489.dentalappointment.service.util.JwtUtilService;

@RestController
@RequestMapping("/auth")
public class UserAuthController {
    private JwtUtilService jwtUtilService;
    private AuthenticationManager authenticationManager;
    private UserService userService;

    public UserAuthController(JwtUtilService jwtUtilService, AuthenticationManager authenticationManager,
            UserService userService) {
        this.jwtUtilService = jwtUtilService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping(value = { "/login" })
    public ResponseEntity<UserAuthDto2> authenticateUser(@RequestBody UserAuthDto userAuthRequest) throws Exception {
        UserAuthDto2 userAuthResponse = null;
        try {
            var username = userAuthRequest.getUsername();
            var password = userAuthRequest.getPassword();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,
                            password));
            var jwtToken = jwtUtilService.generateToken(username);
            var user = userService.getUserByUsername(username);
            if (user != null) {
                userAuthResponse = new UserAuthDto2(jwtToken, user.getFirstName(), user.getLastName());
            }
        } catch (Exception ex) {
            System.out.println("UserAuthException is: " + ex);
            throw ex;
        }
        return ResponseEntity.ok(userAuthResponse);
    }

}
