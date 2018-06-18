package br.josets.foodserviceexample.model;

import java.util.Optional;

import org.apache.commons.text.RandomStringGenerator;

import br.josets.foodserviceexample.exceptions.NotFoundException;
import br.josets.foodserviceexample.repository.UserDAO;

public interface ModelUtilities {

	static String randonUserId() {
		RandomStringGenerator rndStringGen = new RandomStringGenerator.Builder().withinRange('A', 'Z').build();
		return rndStringGen.generate(16).toLowerCase();
	}
	

	static ServiceUser loadUser(UserDAO dao, Long userId) {
		Optional<ServiceUser> foundUser = dao.findById(userId);
		if (!foundUser.isPresent()) {
			throw new NotFoundException("User", "usedId=" +userId);
		}
		return foundUser.get();
	}
	
}
