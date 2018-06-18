package br.josets.foodserviceexample.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.josets.foodserviceexample.model.User;
import br.josets.foodserviceexample.repository.UserDAO;
import javassist.NotFoundException;

@RestController
public class UserController {
	
	@Autowired
	private UserDAO dao;

	@GetMapping("/users")
	public Set<User> listAvailable() {
		return new HashSet<>(dao.findAll());
	}
	
	@PostMapping("/users")
	public User add(@RequestBody User user) {
		return dao.save(user);
	}
	
	@PostMapping("/users/{userId}")
	public User add(@RequestParam String userId, @RequestBody User userSent) throws NotFoundException {
		User foundUser = dao.findByUserId(userId);
		if (foundUser == null) {
			throw new NotFoundException("Could not find the user:" + userId);
		}
		foundUser.setName(userSent.getName());
		return dao.save(foundUser);
	}

}