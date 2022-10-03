package br.com.entra21.emr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.entra21.emr.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

	public List<User> findByNameStartingWith(String prefix);
	
	
}
