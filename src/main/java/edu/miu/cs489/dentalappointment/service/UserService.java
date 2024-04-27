package edu.miu.cs489.dentalappointment.service;

import edu.miu.cs489.dentalappointment.model.User;

public interface UserService {
    User getUserByUsername(String username);

    User registerNewUser(User user);
}
