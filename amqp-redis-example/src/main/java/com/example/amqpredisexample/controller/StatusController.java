package com.example.amqpredisexample.controller;

import java.util.concurrent.atomic.AtomicReference;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amqpredisexample.model.Status;

@RestController
@EnableCaching
public class StatusController {

	private AtomicReference<Status> status = new AtomicReference<Status>(new Status("Loading", 0));

	@Cacheable(value = "post-top")
	@GetMapping("/status")
	public Status get() {
		status.get().inc();
		return status.get();
	}

	@CacheEvict(value = "post-top")
	@GetMapping("/update")
	public Status update() {
		return status.get();
	}

}