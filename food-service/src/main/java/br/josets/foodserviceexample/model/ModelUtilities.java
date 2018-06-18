package br.josets.foodserviceexample.model;

import org.apache.commons.text.RandomStringGenerator;

public interface ModelUtilities {

	static String randonUserId() {
		RandomStringGenerator rndStringGen = new RandomStringGenerator.Builder().withinRange('A', 'Z').build();
		return rndStringGen.generate(16).toLowerCase();
	}
	
	
}
