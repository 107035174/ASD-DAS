package edu.miu.cs489.dentalappointment.service;

import java.util.List;

import edu.miu.cs489.dentalappointment.dto.AddressDto;
import edu.miu.cs489.dentalappointment.exception.AddressNotFoundException;

public interface AddressService {
    public AddressDto add(AddressDto address);

    public List<AddressDto> getAll();

    public AddressDto get(Integer id) throws AddressNotFoundException;

    public AddressDto update(Integer id, AddressDto address) throws AddressNotFoundException;

    public void delete(Integer id);

}
