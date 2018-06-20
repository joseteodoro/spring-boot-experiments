package com.example.mysqldemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.mysqldemo.model.DemoUser;
import com.example.mysqldemo.repository.DemoUserRepository;

@Controller
@RequestMapping(path="/demo")
public class DemoUserController {
	
	@Autowired
	private DemoUserRepository userRepository;
	
	@PostMapping(path="/add")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody String addNewUser (@RequestBody DemoUser user) {
		userRepository.save(user);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<DemoUser> getAllUsers() {
		return userRepository.findAll();
	}

}
