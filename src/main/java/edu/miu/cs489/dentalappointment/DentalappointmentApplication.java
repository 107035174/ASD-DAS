package edu.miu.cs489.dentalappointment;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs489.dentalappointment.dto.AddressDto;
import edu.miu.cs489.dentalappointment.dto.AppointmentDto2;
import edu.miu.cs489.dentalappointment.dto.DentistDto;
import edu.miu.cs489.dentalappointment.dto.DentistDto2;
import edu.miu.cs489.dentalappointment.dto.PatientDto;
import edu.miu.cs489.dentalappointment.dto.PatientDto2;
import edu.miu.cs489.dentalappointment.dto.SurgeryDto;
import edu.miu.cs489.dentalappointment.dto.SurgeryDto2;
import edu.miu.cs489.dentalappointment.service.AddressService;
import edu.miu.cs489.dentalappointment.service.DentistService;
import edu.miu.cs489.dentalappointment.service.PatientService;
import edu.miu.cs489.dentalappointment.service.SurgeryService;
import edu.miu.cs489.dentalappointment.service.impl.AppointmentServiceImpl;

@SpringBootApplication
public class DentalappointmentApplication implements CommandLineRunner {
	@Autowired
	private AppointmentServiceImpl appointmentService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private DentistService dentistService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private SurgeryService surgeryService;
	@Autowired
	private ModelMapper modelMapper;

	public static void main(String[] args) {
		SpringApplication.run(DentalappointmentApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		AddressDto address1 = new AddressDto(null, "123 Maple St", "Springfield", "IL", "62704");
		address1 = addressService.add(address1);

		AddressDto address2 = new AddressDto(null, "456 Oak St", "Shelbyville", "IN", "46176");
		address2 = addressService.add(address2);

		AddressDto address3 = new AddressDto(null, "789 Pine St", "Capital City", "TX", "73301");
		address3 = addressService.add(address3);

		DentistDto2 dentist = new DentistDto2(null, "John", "Doe", "1234567890", "john.doe@example.com", "Orthodontics",
				new ArrayList<>());
		dentist = dentistService.add(dentist);

		DentistDto2 dentist2 = new DentistDto2(null, "Elizabeth", "Turner", "9876543210",
				"elizabeth.turner@example.com", "Periodontics", new ArrayList<>());
		dentist2 = dentistService.add(dentist2);

		PatientDto2 patient2 = new PatientDto2(null, "Alice", "Smith", "1234567890", "alice.smith@example.com",
				address1, null, new ArrayList<>());
		patient2 = patientService.add(patient2);

		PatientDto2 patient = new PatientDto2(null, "Jane", "Doe", "9876543210", "jane.doe@example.com", address2, null,
				new ArrayList<>());
		patient = patientService.add(patient);

		SurgeryDto2 surgery = new SurgeryDto2(null, "Root Canal", null, address3, new ArrayList<>());
		surgery = surgeryService.add(surgery);

		LocalDateTime now = LocalDateTime.now();
		AppointmentDto2 newAppointment = new AppointmentDto2(null, now, now.plusDays(1),
				modelMapper.map(dentist, DentistDto.class),
				modelMapper.map(patient, PatientDto.class),
				modelMapper.map(surgery, SurgeryDto.class));

		appointmentService.add(newAppointment);

		System.out.println("Loaded data into database");

	}

}
