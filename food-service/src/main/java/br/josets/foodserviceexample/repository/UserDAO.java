package br.josets.foodserviceexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.josets.foodserviceexample.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>  {
	
	User findByUserId(String userId);
	
}
