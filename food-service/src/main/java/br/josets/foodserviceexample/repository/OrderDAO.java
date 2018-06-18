package br.josets.foodserviceexample.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.josets.foodserviceexample.model.UserOrder;
import br.josets.foodserviceexample.model.ServiceUser;

@Repository
public interface OrderDAO extends JpaRepository<UserOrder, Long>  {

	Set<UserOrder> findByServiceUser(ServiceUser serviceUser);
	
}
