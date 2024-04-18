package edu.miu.cs489.dentalappointment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.dentalappointment.dto.DentistDto;
import edu.miu.cs489.dentalappointment.dto.DentistDto2;
import edu.miu.cs489.dentalappointment.exception.DentistNotFoundException;
import edu.miu.cs489.dentalappointment.service.DentistService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    private DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @PostMapping("/add")
    public ResponseEntity<DentistDto2> addDentist(@RequestBody DentistDto2 dentist) {
        return new ResponseEntity<>(dentistService.add(dentist), HttpStatus.CREATED);
    }

    @GetMapping("{dentistId}")
    public ResponseEntity<DentistDto> getDentist(@PathVariable Integer dentistId) throws DentistNotFoundException {
        return ResponseEntity.ok(dentistService.get(dentistId));
    }

    @GetMapping("/ls")
    public ResponseEntity<List<DentistDto>> getAllDentist() {
        return ResponseEntity.ok(dentistService.getAll());
    }

    @PutMapping("/{dentistId}")
    public ResponseEntity<DentistDto> editDentist(@PathVariable Integer dentistId, @RequestBody DentistDto dentist)
            throws DentistNotFoundException {
        return new ResponseEntity<>(dentistService.update(dentistId, dentist), HttpStatus.OK);
    }

    @DeleteMapping("/{dentistId}")
    public ResponseEntity<Void> deleteDentist(@PathVariable Integer dentistId) {
        dentistService.delete(dentistId);
        return ResponseEntity.noContent().build();
    }
}
