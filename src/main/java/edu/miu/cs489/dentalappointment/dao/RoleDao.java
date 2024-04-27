package edu.miu.cs489.dentalappointment.dao;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs489.dentalappointment.model.Role;

@Repository
public interface RoleDao extends ListCrudRepository<Role, Integer> {
    Optional<Role> findByRoleName(String roleName);
}
