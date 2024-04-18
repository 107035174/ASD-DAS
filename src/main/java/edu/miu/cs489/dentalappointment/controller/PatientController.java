package edu.miu.cs489.dentalappointment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.dentalappointment.dto.PatientDto;
import edu.miu.cs489.dentalappointment.dto.PatientDto2;
import edu.miu.cs489.dentalappointment.exception.PatientNotFoundException;
import edu.miu.cs489.dentalappointment.service.PatientService;

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
@RequestMapping("/patient")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/add")
    public ResponseEntity<PatientDto2> addPatient(@RequestBody PatientDto2 patient) {
        return new ResponseEntity<>(patientService.add(patient), HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable Integer patientId) throws PatientNotFoundException {
        return ResponseEntity.ok(patientService.get(patientId));
    }

    @GetMapping("/ls")
    public ResponseEntity<List<PatientDto>> getAllPatient() {
        return ResponseEntity.ok(patientService.getAll());
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<PatientDto> editPatient(@PathVariable Integer patientId,
            @RequestBody PatientDto patient) throws PatientNotFoundException {
        return new ResponseEntity<>(patientService.update(patientId, patient), HttpStatus.OK);
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Integer patientId) {
        patientService.delete(patientId);
        return ResponseEntity.noContent().build();
    }

}
