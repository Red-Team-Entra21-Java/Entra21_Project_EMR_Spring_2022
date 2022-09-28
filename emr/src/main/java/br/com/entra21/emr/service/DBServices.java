package br.com.entra21.emr.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entra21.emr.model.Doctor;
import br.com.entra21.emr.repository.IAppointmentRepository;
import br.com.entra21.emr.repository.IDoctorRepository;
import br.com.entra21.emr.repository.IPatientRepository;
import br.com.entra21.emr.repository.ITeamRepository;
import br.com.entra21.emr.repository.IUserRepository;

@Service
public class DBServices {

//	@Autowired
//	private IAppointmentRepository iAppointmentRepository;
//	
//	@Autowired
//	private IDoctorRepository iDoctorRepository;
//	
//	@Autowired
//	private IPatientRepository iPatienttRepository;
//	
//	@Autowired
//	private IUserRepository iUserRepository;
//	
//	@Autowired
//	private ITeamRepository iTeamRepository;
//	
//	public void InstaceDB() {
//		Doctor doctorTest = new Doctor(null, "Doctor Teste", "122", "Mae Teste", "Pai Teste", null, null, null, null, null, null, null, null, null, null, null);
//		
//		iDoctorRepository.saveAll(Arrays.asList(doctorTest));
//	}
}
