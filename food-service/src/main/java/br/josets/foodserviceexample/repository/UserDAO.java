package br.josets.foodserviceexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.josets.foodserviceexample.model.ServiceUser;

@Repository
public interface UserDAO extends JpaRepository<ServiceUser, Long>  {
	
	ServiceUser findByUserId(String userId);
	
}
