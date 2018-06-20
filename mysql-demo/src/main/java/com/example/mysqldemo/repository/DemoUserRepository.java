package com.example.mysqldemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.mysqldemo.model.DemoUser;

public interface DemoUserRepository extends CrudRepository<DemoUser, Long> {

}