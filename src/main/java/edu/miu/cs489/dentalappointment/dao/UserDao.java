package edu.miu.cs489.dentalappointment.dao;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs489.dentalappointment.model.User;

@Repository
public interface UserDao extends ListCrudRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);

}
