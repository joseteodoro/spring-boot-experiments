package br.josets.foodserviceexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.josets.foodserviceexample.model.Food;

@Repository
public interface FoodDAO extends JpaRepository<Food, Long>  {}
