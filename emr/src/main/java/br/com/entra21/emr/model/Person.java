package br.com.entra21.emr.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Person extends MaturidadeNivel3Richardson {

	private String name;
	private String cpf;
	private String nameMother;
	private String nameFather;
	private String genre;
	private LocalDate birth;
	private String streetName;
	private Short numberHome;
	private String district;
	private String city;
	private String state;
	private String country;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(ArrayList<ItemNivel3> links) {
		super(links);
		// TODO Auto-generated constructor stub
	}
	public Person(String name, String cpf, String nameMother, String nameFather, String genre, LocalDate birth,
			String streetName, Short numberHome, String district, String city, String state, String country) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.nameMother = nameMother;
		this.nameFather = nameFather;
		this.genre = genre;
		this.birth = birth;
		this.streetName = streetName;
		this.numberHome = numberHome;
		this.district = district;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNameMother() {
		return nameMother;
	}
	public void setNameMother(String nameMother) {
		this.nameMother = nameMother;
	}
	public String getNameFather() {
		return nameFather;
	}
	public void setNameFather(String nameFather) {
		this.nameFather = nameFather;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public Short getNumberHome() {
		return numberHome;
	}
	public void setNumberHome(Short numberHome) {
		this.numberHome = numberHome;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
	
	
}
