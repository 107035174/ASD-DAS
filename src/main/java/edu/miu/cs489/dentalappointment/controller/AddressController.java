package edu.miu.cs489.dentalappointment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.dentalappointment.dto.AddressDto;
import edu.miu.cs489.dentalappointment.exception.AddressNotFoundException;
import edu.miu.cs489.dentalappointment.model.Address;
import edu.miu.cs489.dentalappointment.service.AddressService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto address) {
        return new ResponseEntity<>(addressService.add(address), HttpStatus.CREATED);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> getAddress(@PathVariable Integer addressId) throws AddressNotFoundException {
        return ResponseEntity.ok(addressService.get(addressId));
    }

    @GetMapping("/ls")
    public ResponseEntity<List<AddressDto>> getAllAddress() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<AddressDto> editAddress(@PathVariable Integer addressId, @RequestBody AddressDto address)
            throws AddressNotFoundException {
        return new ResponseEntity<>(addressService.update(addressId, address), HttpStatus.OK);
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer addressId) {
        addressService.delete(addressId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
