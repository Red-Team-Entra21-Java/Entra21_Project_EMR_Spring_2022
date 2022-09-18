package br.com.entra21.emr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.entra21.emr.model.Appointment;

public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {

}
