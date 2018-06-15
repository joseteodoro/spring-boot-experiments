package br.josets.webflux.server.repository;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.text.RandomStringGenerator;

import br.josets.webflux.server.model.Vehicle;

public interface HighwayUtilities {
	
	static DecimalFormat plateFormatNumber = new DecimalFormat("0000");
	static String[] COLORS = { "Blue", "White", "Silver", "Black", "Metalic Green", "Orange", "Yellow" };
	static String[] GAS_TYPE = { "Diesel", "Gasoline", "Gas", "Eletric", "Alcohol" };
	
	static Vehicle simulateTraffic() {
		RandomStringGenerator rndStringGen = new RandomStringGenerator.Builder().withinRange('A', 'Z').build();

		StringBuffer sb = new StringBuffer(rndStringGen.generate(3).toUpperCase());
		sb.append(" ");
		sb.append(plateFormatNumber.format(ThreadLocalRandom.current().nextInt(0, 9999)));
		String carPlateNumber = sb.toString();

		Long weight = ThreadLocalRandom.current().nextLong(250L, 4500L);
		Integer speed = ThreadLocalRandom.current().nextInt(60, 175);

		String color = COLORS[ThreadLocalRandom.current().nextInt(0, 6)];
		Integer modelYear = ThreadLocalRandom.current().nextInt(1975, 2018);
		String gasType = GAS_TYPE[ThreadLocalRandom.current().nextInt(0, 4)];

		return new Vehicle(carPlateNumber, weight, speed, color, modelYear, gasType);
	}

}
