package br.com.entra21.emr.controller;

import java.time.LocalDate;
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

import br.com.entra21.emr.model.Doctor;
import br.com.entra21.emr.model.ItemNivel3;
import br.com.entra21.emr.model.Patient;
import br.com.entra21.emr.repository.IDoctorRepository;
import br.com.entra21.emr.repository.IPatientRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private IDoctorRepository doctorRepository;
	
//	LIST ALL
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Doctor> list() {
		
		List<Doctor> response = doctorRepository.findAll();
		response.forEach(doctor ->{
			setMaturidadeNivel3(doctor);
		});
		
		return response;
	}
	
	
	// LIST FOR ID
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Doctor> search(@PathVariable("id") int param) {

		List<Doctor> response = doctorRepository.findById(param).stream().toList();

		return response;
	}
	
	// CREATE
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Doctor add(@RequestBody Doctor newDoctor) {

		return doctorRepository.save(newDoctor);
	}
	
	//UPDATE
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Optional<Doctor> atualizar(@PathVariable("id") int param,
			@RequestBody Doctor newDataDoctor) {

		Doctor current = doctorRepository.findById(param).get();
		current.setName(newDataDoctor.getName());
		current.setCpf(newDataDoctor.getCpf());
		current.setNameMother(newDataDoctor.getNameMother());
		current.setNameFather(newDataDoctor.getNameFather());
		current.setGenre(newDataDoctor.getGenre());
		current.setBirth(newDataDoctor.getBirth());
		current.setStreetName(newDataDoctor.getStreetName());
		current.setNumberHome(newDataDoctor.getNumberHome());
		current.setDistrict(newDataDoctor.getDistrict());
		current.setCity(newDataDoctor.getCity());
		current.setState(newDataDoctor.getState());
		current.setCountry(newDataDoctor.getCountry());
		current.setRegisterNumber(newDataDoctor.getRegisterNumber());
		current.setRegisterDistrict(newDataDoctor.getRegisterDistrict());
		current.setSpecialty(newDataDoctor.getSpecialty());
		doctorRepository.save(current);

		return doctorRepository.findById(param);
	}
	
	// DELETE
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody boolean delete(@PathVariable("id") int id) {
		doctorRepository.deleteById(id);

		return !doctorRepository.existsById(id);
	}
	
	private void setMaturidadeNivel3(Doctor doctor) {

		final String PATH = "localhost:8080/doctor";

		ArrayList<String> headers = new ArrayList<String>();

		headers.add("Accept : application/json");

		headers.add("Content-type : application/json");

		ObjectMapper mapper = new ObjectMapper();

		mapper.setSerializationInclusion(Include.NON_NULL);

		try {

			Doctor clone = mapper.readValue(mapper.writeValueAsString(doctor), Doctor.class);

			clone.setLinks(null);

			String name = clone.getName();
			String cpf = clone.getCpf();
			String nameMother = clone.getNameMother();
			String nameFather = clone.getNameFather();
			String genre = clone.getGenre();
			LocalDate birth = clone.getBirth();
			String streetName = clone.getStreetName();
			Short numberHome = clone.getNumberHome();
			String district = clone.getDistrict();
			String city = clone.getCity();
			String state = clone.getState();
			String country = clone.getCountry();
			String registerNumber = clone.getRegisterNumber();
			String registerDistrict = clone.getRegisterDistrict();
			String specialty = clone.getSpecialty();
			
			clone.setName("Different name");
			clone.setCpf("Different login");
			clone.setNameMother("Different email");
			clone.setNameFather("Different password");
			clone.setGenre("Different password");
			clone.setBirth(LocalDate.of(2015, 12, 11));
			clone.setStreetName("Different password");
			clone.setNumberHome((short) 123);
			clone.setDistrict("Different password");
			clone.setCity("Different password");
			clone.setState("Different password");
			clone.setCountry("Different password");
			clone.setRegisterNumber("12345-1");
			clone.setRegisterDistrict("SC");
			clone.setSpecialty("Different Specialty");			
					
			String jsonUpdate = mapper.writeValueAsString(clone);

			clone.setName(name);
			clone.setCpf(cpf);
			clone.setNameMother(nameMother);
			clone.setNameFather(nameFather);
			clone.setGenre(genre);
			clone.setBirth(birth);
			clone.setStreetName(streetName);
			clone.setNumberHome(numberHome);
			clone.setDistrict(district);
			clone.setCity(city);
			clone.setState(state);
			clone.setCountry(country);
			clone.setRegisterNumber(registerNumber);
			clone.setRegisterDistrict(registerDistrict);
			clone.setSpecialty(specialty);
			
			clone.setId(null);

			String jsonCreate = mapper.writeValueAsString(clone);

			doctor.setLinks(new ArrayList<>());
			doctor.getLinks().add(new ItemNivel3("GET", PATH, null, null));
			doctor.getLinks().add(new ItemNivel3("GET", PATH + "/" + patient.getId(), null, null));
			doctor.getLinks().add(new ItemNivel3("POST", PATH, headers, jsonCreate));
			doctor.getLinks().add(new ItemNivel3("PUT", PATH + "/" + patient.getId(), headers, jsonUpdate));

		} catch (JsonProcessingException e) {

			e.printStackTrace();

		}

	}
	
}
