package edu.miu.cs489.dentalappointment.dao;

import org.springframework.data.repository.ListCrudRepository;

import edu.miu.cs489.dentalappointment.model.Patient;

public interface PatientDao extends ListCrudRepository<Patient, Integer> {

}
