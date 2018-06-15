package br.josets.webflux.server.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.josets.webflux.server.model.Vehicle;
import br.josets.webflux.server.repository.HighwayTraffic;
import reactor.core.publisher.Mono;

@Component

public class HighwayHandler {

    @Autowired
    HighwayTraffic highwayTraffic;
    
    public Mono<ServerResponse> vehicleDetected(ServerRequest request) {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_STREAM_JSON)
            .body(highwayTraffic.flowTraffic(),Vehicle.class);
    }

}
