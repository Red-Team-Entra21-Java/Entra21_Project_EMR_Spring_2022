package br.com.entra21.emr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.entra21.emr.model.Doctor;


public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

}
