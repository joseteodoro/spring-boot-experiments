package br.josets.jdk10.restservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.josets.jdk10.restservice.hello.Greeting;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestServiceApplicationTests {

	@Autowired
	private WebTestClient webClient;
	
	@Test
	public void exampleTest() {
		this.webClient.get()
			.uri("/greeting")
			.exchange()
			.expectStatus()
			.isOk()
			.expectBody(Greeting.class).isEqualTo(new Greeting(1, "Hello, World!"));
	}

	
}
