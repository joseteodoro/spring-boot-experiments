package br.josets.webflux.server.repository;

import br.josets.webflux.server.model.Vehicle;
import reactor.core.publisher.Flux;

public interface HighwayTraffic {
	
	public Flux<Vehicle> flowTraffic();
	
}
