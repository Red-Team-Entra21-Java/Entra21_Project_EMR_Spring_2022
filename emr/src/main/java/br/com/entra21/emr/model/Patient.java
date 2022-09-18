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
@Table(name="patient_emr")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Patient extends Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(ArrayList<ItemNivel3> links) {
		super(links);
		// TODO Auto-generated constructor stub
	}

	public Patient(String name, String cpf, String nameMother, String nameFather, String genre, LocalDate birth,
			String streetName, Short numberHome, String district, String city, String state, String country) {
		super(name, cpf, nameMother, nameFather, genre, birth, streetName, numberHome, district, city, state, country);
		// TODO Auto-generated constructor stub
	}

	public Patient(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
