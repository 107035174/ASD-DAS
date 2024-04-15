package edu.miu.cs489.dentalappointment.service;

import java.util.List;

import edu.miu.cs489.dentalappointment.dto.AddressDto;
import edu.miu.cs489.dentalappointment.exception.AddressNotFoundException;
import edu.miu.cs489.dentalappointment.model.Address;

public interface AddressService {
    public AddressDto add(AddressDto address);

    public List<AddressDto> getAll();

    public Address get(Integer id) throws AddressNotFoundException;

    public Address update(Integer id, Address address) throws AddressNotFoundException;

    public void delete(Integer id);

}
