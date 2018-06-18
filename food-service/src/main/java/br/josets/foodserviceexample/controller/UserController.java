package br.josets.foodserviceexample.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.josets.foodserviceexample.exceptions.NotFoundException;
import br.josets.foodserviceexample.model.ModelUtilities;
import br.josets.foodserviceexample.model.ServiceUser;
import br.josets.foodserviceexample.repository.UserDAO;

@RestController
public class UserController {
	
	@Autowired
	private UserDAO dao;

	@GetMapping("/users")
	public Set<ServiceUser> listAvailable() {
		return new HashSet<>(dao.findAll());
	}
	
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceUser add(@RequestBody ServiceUser user) {
		return dao.save(user);
	}
	
	@GetMapping("/users/{userId}")
	public ServiceUser add(@PathVariable(name="userId") Long userId) {
		return ModelUtilities.loadUser(dao, userId);
	}
	
	@PostMapping("/users/{userId}")
	public ServiceUser add(@PathVariable(name="userId") Long userId, @RequestBody ServiceUser userSent) throws NotFoundException {
		ServiceUser foundUser  = ModelUtilities.loadUser(dao, userId);
		foundUser.setName(userSent.getName());
		return dao.save(foundUser);
	}

}