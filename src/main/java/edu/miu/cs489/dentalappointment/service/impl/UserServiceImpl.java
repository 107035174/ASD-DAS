package edu.miu.cs489.dentalappointment.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.UserDao;
import edu.miu.cs489.dentalappointment.model.User;
import edu.miu.cs489.dentalappointment.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private PasswordEncoder passwordEncoder;
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findUserByUsername(username)
                .orElse(null);
    }

    @Override
    public User registerNewUser(User user) {
        if (userDao.findUserByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userDao.save(user);
        return savedUser;
    }

}
