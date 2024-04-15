package edu.miu.cs489.dentalappointment;

// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.util.ArrayList;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import edu.miu.cs489.dentalappointment.model.Address;
// import edu.miu.cs489.dentalappointment.model.Appointment;
// import edu.miu.cs489.dentalappointment.model.Dentist;
// import edu.miu.cs489.dentalappointment.model.Patient;
// import edu.miu.cs489.dentalappointment.model.Surgery;
// import edu.miu.cs489.dentalappointment.service.AddressService;
// import edu.miu.cs489.dentalappointment.service.AppointmentService;
// import edu.miu.cs489.dentalappointment.service.DentistService;
// import edu.miu.cs489.dentalappointment.service.PatientService;
// import edu.miu.cs489.dentalappointment.service.SurgeryService;

@SpringBootApplication
public class DentalappointmentApplication {
	// implements CommandLineRunner {

	// private final AddressService addressService;
	// private final AppointmentService appointmentService;
	// private final DentistService dentistService;
	// private final PatientService patientService;
	// private final SurgeryService surgeryService;

	// public DentalappointmentApplication(AddressService addressService,
	// AppointmentService appointmentService,
	// DentistService dentistService, PatientService patientService, SurgeryService
	// surgeryService) {
	// this.addressService = addressService;
	// this.appointmentService = appointmentService;
	// this.dentistService = dentistService;
	// this.patientService = patientService;
	// this.surgeryService = surgeryService;
	// }

	public static void main(String[] args) {
		SpringApplication.run(DentalappointmentApplication.class, args);

	}

	// @Override
	// public void run(String... args) throws Exception {

	// Address add1 = addAddress("1000 N 4th st", "Iowa", "Fairfield", "52557");
	// Address add2 = addAddress("1000 N 4th st", "Iowa", "Fairfield", "52557");
	// Address add3 = addAddress("1000 N 4th st", "Iowa", "Fairfield", "52557");
	// Address add4 = addAddress("1000 N 4th st", "Iowa", "Fairfield", "52557");
	// Address add5 = addAddress("1000 N 4th st", "Iowa", "Fairfield", "52557");
	// Address add6 = addAddress("1000 N 4th st", "Iowa", "Fairfield", "52557");
	// Address add7 = addAddress("1000 N 4th st", "Iowa", "Fairfield", "52557");

	// Dentist den1 = addDentist("Tony", "Smith", "000-0000-0000", "den1email",
	// "spec1");
	// Dentist den2 = addDentist("Helen", "Pearson", "000-0000-0001", "den2email",
	// "spec2");
	// Dentist den3 = addDentist("Robin", "Plevin", "000-0000-0002", "den3email",
	// "spec3");

	// Patient pan1 = addPatient("Gillian", "White", "000-0000-1000", "pat1email",
	// add1, LocalDate.of(1999, 6, 21));
	// Patient pan2 = addPatient("Jill", "Bell", "000-0000-1001", "pat2email", add2,
	// LocalDate.of(1999, 6, 22));
	// Patient pan3 = addPatient("Ian", "MacKay", "000-0000-1002", "pat3email",
	// add3, LocalDate.of(1999, 6, 23));
	// Patient pan4 = addPatient("John", "Walker", "000-0000-1003", "pat4email",
	// add4, LocalDate.of(1999, 6, 24));

	// Surgery sur1 = addSurgery("S15", "000-0000-2000", add5);
	// Surgery sur2 = addSurgery("S10", "000-0000-2001", add6);
	// Surgery sur3 = addSurgery("S13", "000-0000-2002", add7);

	// addAppointment(LocalDateTime.of(2024, 9, 12, 10, 0), pan1, den1, sur1);
	// addAppointment(LocalDateTime.of(2024, 9, 12, 10, 0), pan2, den1, sur1);
	// addAppointment(LocalDateTime.of(2024, 9, 12, 10, 0), pan3, den2, sur2);
	// addAppointment(LocalDateTime.of(2024, 9, 12, 10, 0), pan3, den2, sur2);
	// addAppointment(LocalDateTime.of(2024, 9, 12, 10, 0), pan2, den3, sur1);
	// addAppointment(LocalDateTime.of(2024, 9, 12, 10, 0), pan4, den3, sur3);

	// }

	// private Address addAddress(String street, String city, String state, String
	// zip) {
	// return addressService.add(new Address(null, street, city, state, zip));
	// }

	// private Appointment addAppointment(LocalDateTime scheduledDateTime, Patient
	// patient, Dentist dentist,
	// Surgery surgery) {
	// return appointmentService
	// .add(new Appointment(null, LocalDateTime.now(), scheduledDateTime, patient,
	// surgery, dentist));
	// }

	// private Dentist addDentist(String firstName, String lastName, String
	// phoneNumber, String email,
	// String specialization) {
	// return dentistService
	// .add(new Dentist(null, firstName, lastName, phoneNumber, email,
	// specialization, new ArrayList<>()));
	// }

	// private Patient addPatient(String firstName, String lastName, String
	// phoneNumber, String email,
	// Address mailingAddress, LocalDate dob) {
	// return patientService
	// .add(new Patient(null, firstName, lastName, phoneNumber, email,
	// mailingAddress, dob,
	// new ArrayList<>()));
	// }

	// private Surgery addSurgery(String name, String phoneNumber, Address address)
	// {
	// return surgeryService.add(new Surgery(null, name, phoneNumber, address, new
	// ArrayList<>()));
	// }

}
