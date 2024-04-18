package edu.miu.cs489.dentalappointment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.dentalappointment.dto.AppointmentDto;
import edu.miu.cs489.dentalappointment.dto.AppointmentDto2;
import edu.miu.cs489.dentalappointment.exception.AppointmentNotFoundException;
import edu.miu.cs489.dentalappointment.model.Appointment;
import edu.miu.cs489.dentalappointment.service.AppointmentService;

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
@RequestMapping("/appointment")
public class AppointmentController {
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/add")
    public ResponseEntity<AppointmentDto> addAppointment(@RequestBody AppointmentDto appointment) {
        return new ResponseEntity<>(appointmentService.add(appointment), HttpStatus.CREATED);
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Integer appointmentId)
            throws AppointmentNotFoundException {
        return ResponseEntity.ok(appointmentService.get(appointmentId));
    }

    @GetMapping("/ls")
    public ResponseEntity<List<AppointmentDto>> getAllAppointmment() {
        return ResponseEntity.ok(appointmentService.getAll());
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDto2> editAppointment(@PathVariable Integer appointmentId,
            @RequestBody AppointmentDto2 appointment) throws AppointmentNotFoundException {
        return new ResponseEntity<>(appointmentService.update(appointmentId, appointment), HttpStatus.OK);
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Integer appointmentId) {
        appointmentService.delete(appointmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
