package br.josets.webflux.client;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import br.josets.webflux.server.model.Vehicle;
import reactor.core.Disposable;
import reactor.core.scheduler.Schedulers;

public class ClientApplication {

	private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8090").build();

	public Disposable vehicleDetected() {
		AtomicInteger counter = new AtomicInteger(0);
		return webClient.get()
				.uri("/vehicles")
				.accept(MediaType.APPLICATION_STREAM_JSON)
				.exchange()
				.publishOn(Schedulers.single())
				.flatMapMany(response -> response.bodyToFlux(Vehicle.class))
				.delayElements(Duration.ofMillis(1000))
				.subscribe(s -> {
						System.out.println(counter.incrementAndGet() + " >>>>>>>>>>>> " + s);
					}, err -> {
						System.out.println("Error on Vehicle Stream: " + err);
					}, () -> {
						System.out.println("Vehicle stream stoped!");
					});
	}

	public Disposable vehicleHigherThen120Detected() {
		AtomicInteger counter = new AtomicInteger(0);
		return webClient.get().uri("/vehicles").accept(MediaType.APPLICATION_STREAM_JSON).exchange()
				.flatMapMany(response -> response.bodyToFlux(Vehicle.class)).filter(v -> v.getSpeed() > 120)
				.delayElements(Duration.ofMillis(250)).subscribe(s -> {
					System.out.println(counter.incrementAndGet() + " >> 120Km+ >> " + s);
				}, err -> System.out.println("Error on Vehicle Stream: " + err),
						() -> System.out.println("Vehicle stream stoped!"));
	}

	public static void main(String[] args) {
		ClientApplication vehiclesWebClient = new ClientApplication();
        Disposable disposable = vehiclesWebClient.vehicleDetected();
        try {
            Thread.sleep(32000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            disposable.dispose();
        }
	}
}
