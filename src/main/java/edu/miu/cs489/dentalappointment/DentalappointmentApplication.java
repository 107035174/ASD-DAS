package edu.miu.cs489.dentalappointment;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs489.dentalappointment.dao.DentistDao;
import edu.miu.cs489.dentalappointment.dao.PatientDao;
import edu.miu.cs489.dentalappointment.dao.SurgeryDao;
import edu.miu.cs489.dentalappointment.dto.AppointmentDto2;
import edu.miu.cs489.dentalappointment.dto.DentistDto2;
import edu.miu.cs489.dentalappointment.dto.PatientDto2;
import edu.miu.cs489.dentalappointment.dto.SurgeryDto2;
import edu.miu.cs489.dentalappointment.model.Dentist;
import edu.miu.cs489.dentalappointment.model.Patient;
import edu.miu.cs489.dentalappointment.model.Surgery;
import edu.miu.cs489.dentalappointment.service.impl.AppointmentServiceImpl;

@SpringBootApplication
public class DentalappointmentApplication implements CommandLineRunner {
	@Autowired
	private AppointmentServiceImpl appointmentService;
	@Autowired
	private DentistDao dentistDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private SurgeryDao surgeryDao;

	public static void main(String[] args) {
		SpringApplication.run(DentalappointmentApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Dentist dentist = new Dentist(null, "John", "Doe", "1234567890", "john.doe@example.com", "Orthodontics",
				new ArrayList<>());
		dentist = dentistDao.save(dentist);

		Dentist dentist2 = new Dentist(null, "Elizabeth", "Turner", "9876543210", "elizabeth.turner@example.com",
				"Periodontics", new ArrayList<>());
		dentist2 = dentistDao.save(dentist2);

		Patient patient = new Patient(null, "Jane", "Doe", "9876543210", "jane.doe@example.com", null, null,
				new ArrayList<>());
		patient = patientDao.save(patient);

		Surgery surgery = new Surgery(null, "Root Canal", null, null, new ArrayList<>());
		surgery = surgeryDao.save(surgery);

		LocalDateTime now = LocalDateTime.now();
		AppointmentDto2 newAppointment = new AppointmentDto2(null, now, now.plusDays(1), new DentistDto2(1),
				new PatientDto2(1), new SurgeryDto2(1));
		appointmentService.add(newAppointment);

		System.out.println("Loaded data into database");
	}

}
