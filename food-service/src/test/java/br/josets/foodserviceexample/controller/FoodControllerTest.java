package br.josets.foodserviceexample.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import br.josets.foodserviceexample.model.Food;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class FoodControllerTest {
	
	@Autowired
	private WebTestClient webClient;
	
	@Test
	public void getMenusWithSuccessTest() {
		this.webClient.get().uri("/menu").exchange().expectStatus().isOk();
	}
	
	@Test
	public void postWithSuccessTest() {
		Food user = new Food();
		user.setName("banana");
		this.webClient.post().uri("/menu")
			.body(BodyInserters.fromObject(user))
			.exchange()
			.expectStatus()
			.isCreated();
		this.webClient.get().uri("/menu/"+user.getName())
			.exchange()
			.expectStatus()
			.isOk();
	}
	
	@Test
	public void getUnexistentUserTest() {
		this.webClient.get().uri("/menu//notfound")
			.exchange()
			.expectStatus()
			.isNotFound();
	}

}
