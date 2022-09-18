package br.com.entra21.emr.model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="doctor_emr")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Doctor extends Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String registerNumber;
	private String registerDistrict;
	private String specialty;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(ArrayList<ItemNivel3> links) {
		super(links);
		// TODO Auto-generated constructor stub
	}
	public Doctor(String name, String cpf, String nameMother, String nameFather, String genre, LocalDate birth,
			String streetName, Short numberHome, String district, String city, String state, String country) {
		super(name, cpf, nameMother, nameFather, genre, birth, streetName, numberHome, district, city, state, country);
		// TODO Auto-generated constructor stub
	}
	public Doctor(Integer id, String registerNumber, String registerDistrict, String specialty) {
		super();
		this.id = id;
		this.registerNumber = registerNumber;
		this.registerDistrict = registerDistrict;
		this.specialty = specialty;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	public String getRegisterDistrict() {
		return registerDistrict;
	}
	public void setRegisterDistrict(String registerDistrict) {
		this.registerDistrict = registerDistrict;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	
	
}
