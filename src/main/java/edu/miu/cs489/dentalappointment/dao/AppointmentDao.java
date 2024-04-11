package edu.miu.cs489.dentalappointment.dao;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs489.dentalappointment.model.Appointment;

@Repository
public interface AppointmentDao extends ListCrudRepository<Appointment, Integer> {

}
