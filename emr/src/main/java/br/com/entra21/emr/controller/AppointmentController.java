package br.com.entra21.emr.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.entra21.emr.model.Appointment;
import br.com.entra21.emr.model.ItemNivel3;
import br.com.entra21.emr.repository.IAppointmentRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private IAppointmentRepository appointmentRepository;

	// LIST ALL

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Appointment> list() {

		List<Appointment> response = appointmentRepository.findAll();
		response.forEach(appointment -> {
			setMaturidadeNivel3(appointment);
		});

		return response;
	}

	// LIST FOR ID
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Appointment> search(@PathVariable("id") int param) {

		List<Appointment> response = appointmentRepository.findById(param).stream().toList();

		return response;
	}

	// CREATE
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Appointment add(@RequestBody Appointment newAppointment) {

		return appointmentRepository.save(newAppointment);
	}

	//UPDATE
		@PutMapping("/{id}")
		@ResponseStatus(HttpStatus.OK)
		public @ResponseBody Optional<Appointment> atualizar(@PathVariable("id") int param,
				@RequestBody Appointment newDataAppointment) {

			Appointment current = appointmentRepository.findById(param).get();
			current.setPatient_id(newDataAppointment.getPatient_id());
			current.setDoctor_id(newDataAppointment.getDoctor_id());
			current.setDate(newDataAppointment.getDate());
			current.setHour(newDataAppointment.getHour());
			current.setAnamnesis(newDataAppointment.getAnamnesis());
			current.setPrescription(newDataAppointment.getPrescription());
			current.setCertificate(newDataAppointment.getCertificate());
			current.setForwarding(newDataAppointment.getForwarding());
			current.setMedicalRelease(newDataAppointment.getMedicalRelease());
			
			appointmentRepository.save(current);

			return appointmentRepository.findById(param);
		}
	
	
		// DELETE
		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.OK)
		public @ResponseBody boolean delete(@PathVariable("id") int id) {
			appointmentRepository.deleteById(id);

			return !appointmentRepository.existsById(id);
		}
	
	
	
	
	
	private void setMaturidadeNivel3(Appointment appointment) {

		final String PATH = "localhost:8080/appointment";

		ArrayList<String> headers = new ArrayList<String>();

		headers.add("Accept : application/json");

		headers.add("Content-type : application/json");

		ObjectMapper mapper = new ObjectMapper();

		mapper.setSerializationInclusion(Include.NON_NULL);

		try {

			Appointment clone = mapper.readValue(mapper.writeValueAsString(appointment), Appointment.class);

			clone.setLinks(null);

			Integer patient_id = clone.getPatient_id();
			Integer doctor_id = clone.getDoctor_id();
			LocalDate date = clone.getDate();
			LocalTime hour = clone.getHour();
			String anamnesis = clone.getAnamnesis();
			String prescription = clone.getPrescription();
			String certificate = clone.getCertificate();
			String forwarding = clone.getForwarding();
			String medicalRelease = clone.getMedicalRelease();

			clone.setPatient_id(1);
			clone.setDoctor_id(1);
			clone.setDate(LocalDate.of(2015, 12, 11));
			clone.setHour(LocalTime.of(02, 17));
			clone.setAnamnesis("Different password");
			clone.setPrescription("Different password");
			clone.setCertificate("Different password");
			clone.setForwarding("Different password");
			clone.setMedicalRelease("Different password");

			String jsonUpdate = mapper.writeValueAsString(clone);

			clone.setPatient_id(patient_id);
			clone.setDoctor_id(doctor_id);
			clone.setDate(date);
			clone.setHour(hour);
			clone.setAnamnesis(anamnesis);
			clone.setPrescription(prescription);
			clone.setCertificate(certificate);
			clone.setForwarding(forwarding);
			clone.setMedicalRelease(medicalRelease);

			clone.setId(null);

			String jsonCreate = mapper.writeValueAsString(clone);

			appointment.setLinks(new ArrayList<>());

			appointment.getLinks().add(new ItemNivel3("GET", PATH, null, null));

			appointment.getLinks().add(new ItemNivel3("GET", PATH + "/" + appointment.getId(), null, null));

			appointment.getLinks().add(new ItemNivel3("POST", PATH, headers, jsonCreate));

			appointment.getLinks().add(new ItemNivel3("PUT", PATH + "/" + appointment.getId(), headers, jsonUpdate));

		} catch (JsonProcessingException e) {

			e.printStackTrace();

		}

	}

}
