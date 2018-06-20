package br.josets.jdk10.restservice.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GrettingControllerTest {

	@Autowired
	private WebTestClient webClient;

	@Test
	public void greetingDefaultTest() {
		String template = "Hello, %s!";
		this.webClient.get().uri("/greeting").exchange().expectStatus().isOk()
				.expectBody(Greeting.class).isEqualTo(new Greeting(String.format(template, "World")));
	}
	
	@Test
	public void greetingNameTest() {
		String template = "Hello, %s!";
		String name = "simple name";
		this.webClient.get().uri(uriBuilder -> uriBuilder.path("/greeting")
                .queryParam("name", name)
                .build()).exchange().expectStatus().isOk()
				.expectBody(Greeting.class).isEqualTo(new Greeting(String.format(template, name)));
	}
	
	@Test
	public void notFoundTest() {
		this.webClient.get().uri("/unexistent").exchange().expectStatus().isNotFound();
	}

}
