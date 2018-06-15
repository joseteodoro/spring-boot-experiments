package br.josets.webflux.server.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.josets.webflux.server.model.Vehicle;
import br.josets.webflux.server.repository.HighwayTraffic;
import reactor.core.publisher.Flux;

@RestController
public class HighwayController {

	@Autowired
    HighwayTraffic highwayTraffic;
	
	@GetMapping(path="/vehicles", produces=MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Vehicle> vehicles() {
        return highwayTraffic.flowTraffic();
    }
}
