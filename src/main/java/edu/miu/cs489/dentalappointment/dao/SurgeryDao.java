package edu.miu.cs489.dentalappointment.dao;

import org.springframework.data.repository.ListCrudRepository;

import edu.miu.cs489.dentalappointment.model.Surgery;

public interface SurgeryDao extends ListCrudRepository<Surgery, Integer> {

}
