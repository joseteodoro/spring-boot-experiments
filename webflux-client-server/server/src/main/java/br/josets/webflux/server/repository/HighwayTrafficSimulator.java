package br.josets.webflux.server.repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.josets.webflux.server.model.Vehicle;
import reactor.core.publisher.Flux;

@Service
public class HighwayTrafficSimulator implements HighwayTraffic {

	private static Logger LOGGER = LoggerFactory.getLogger(HighwayTrafficSimulator.class);

	public HighwayTrafficSimulator() {
	}

	public Flux<Vehicle> flowTraffic() {
		LocalDateTime startTime = LocalDateTime.now();

		return Flux.<Vehicle>create(fluxSink -> {
			boolean inFrameTime = true;
			int index = 1;
			while (index <= 30000 && inFrameTime && !fluxSink.isCancelled() ) {
				fluxSink.next(HighwayUtilities.simulateTraffic());
				index++;

				long timeMinutesHighwayOpened = startTime.until(LocalDateTime.now(), 
						ChronoUnit.MILLIS);
				if (timeMinutesHighwayOpened > 30000) {
					LOGGER.info("TrafficSimulator finish --> With timer");
					inFrameTime = false;
				}
			}
		}).share();
	}

}
