package edu.miu.cs489.dentalappointment.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs489.dentalappointment.dto.AddressDto;
import edu.miu.cs489.dentalappointment.model.Address;

public interface AddressService {
    public Address add(Address address);

    public List<AddressDto> getAll();

    public Optional<Address> get(Integer id);

    public void update(Integer id, Address address);

    public void delete(Integer id);

}
