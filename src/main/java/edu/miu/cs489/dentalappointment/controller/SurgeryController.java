package edu.miu.cs489.dentalappointment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.dentalappointment.dto.SurgeryDto;
import edu.miu.cs489.dentalappointment.dto.SurgeryDto2;
import edu.miu.cs489.dentalappointment.exception.SurgeryNotFoundException;
import edu.miu.cs489.dentalappointment.service.SurgeryService;

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
@RequestMapping("/surgery")
public class SurgeryController {
    private SurgeryService surgeryService;

    public SurgeryController(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }

    @PostMapping("/add")
    public ResponseEntity<SurgeryDto2> addSurgery(@RequestBody SurgeryDto2 surgery) {
        return new ResponseEntity<>(surgeryService.add(surgery), HttpStatus.CREATED);
    }

    @GetMapping("/{surgeryId}")
    public ResponseEntity<SurgeryDto> getPatient(@PathVariable Integer patientId) throws SurgeryNotFoundException {
        return ResponseEntity.ok(surgeryService.get(patientId));
    }

    @GetMapping("/ls")
    public ResponseEntity<List<SurgeryDto>> getAllSurgery() {
        return ResponseEntity.ok(surgeryService.getAll());
    }

    @PutMapping("/{surgeryId}")
    public ResponseEntity<SurgeryDto> editSurgery(@PathVariable Integer surgeryId, @RequestBody SurgeryDto surgery)
            throws SurgeryNotFoundException {
        return new ResponseEntity<>(surgeryService.update(surgeryId, surgery), HttpStatus.OK);
    }

    @DeleteMapping("/{surgeryId}")
    public ResponseEntity<Void> deleteSurgery(@PathVariable Integer surgeryId) {
        surgeryService.delete(surgeryId);
        return ResponseEntity.noContent().build();
    }

}
