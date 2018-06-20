package br.josets.jooqgenerator.repository;

import org.springframework.data.repository.CrudRepository;

import br.josets.jooqgenerator.model.DemoUser;

public interface DemoUserRepository extends CrudRepository<DemoUser, Long> {

}