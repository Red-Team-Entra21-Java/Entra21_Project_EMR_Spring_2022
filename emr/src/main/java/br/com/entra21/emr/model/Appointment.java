package br.com.entra21.emr.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="appointment_emr")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Appointment extends MaturidadeNivel3Richardson {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer patient_id;
	private Integer doctor_id;
	private LocalDate date;
	private LocalTime hour;
	private String anamnesis;
	private String prescription;
	private String certificate;
	private String forwarding;
	private String medicalRelease;
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(ArrayList<ItemNivel3> links) {
		super(links);
		// TODO Auto-generated constructor stub
	}
	public Appointment(Integer id, Integer patient_id, Integer doctor_id, LocalDate date, LocalTime hour,
			String anamnesis, String prescription, String certificate, String forwarding, String medicalRelease) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.date = date;
		this.hour = hour;
		this.anamnesis = anamnesis;
		this.prescription = prescription;
		this.certificate = certificate;
		this.forwarding = forwarding;
		this.medicalRelease = medicalRelease;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	public Integer getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getHour() {
		return hour;
	}
	public void setHour(LocalTime hour) {
		this.hour = hour;
	}
	public String getAnamnesis() {
		return anamnesis;
	}
	public void setAnamnesis(String anamnesis) {
		this.anamnesis = anamnesis;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getForwarding() {
		return forwarding;
	}
	public void setForwarding(String forwarding) {
		this.forwarding = forwarding;
	}
	public String getMedicalRelease() {
		return medicalRelease;
	}
	public void setMedicalRelease(String medicalRelease) {
		this.medicalRelease = medicalRelease;
	}
	
	
}