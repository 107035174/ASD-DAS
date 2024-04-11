package edu.miu.cs489.dentalappointment.dao;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs489.dentalappointment.model.Address;

@Repository
public interface AddressDao extends ListCrudRepository<Address, Integer> {

}
