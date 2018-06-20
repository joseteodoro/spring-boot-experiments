package br.josets.foodserviceexample.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import br.josets.foodserviceexample.model.ServiceUser;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
	
	@Autowired
	private WebTestClient webClient;
	
	@Test
	public void getUsersWithSuccessTest() {
		this.webClient.get().uri("/users").exchange().expectStatus().isOk();
	}
	
	@Test
	public void postWithSuccessTest() {
		ServiceUser user = new ServiceUser();
		user.setName("banana");
		user.setUserId("mr. banana");
		this.webClient.post().uri("/users")
			.body(BodyInserters.fromObject(user))
			.exchange()
			.expectStatus()
			.isCreated();
		this.webClient.get().uri("/users/"+user.getUserId())
			.exchange()
			.expectStatus()
			.isOk();
	}
	
	@Test
	public void getUnexistentUserTest() {
		this.webClient.get().uri("/users/notfound")
			.exchange()
			.expectStatus()
			.isNotFound();
	}
	
	@Test
	public void updateUserNameWithSuccessTest() {
		ServiceUser user = new ServiceUser();
		user.setName("coconut");
		user.setUserId("ccnt");
		this.webClient.post().uri("/users")
			.body(BodyInserters.fromObject(user))
			.exchange()
			.expectStatus()
			.isCreated();
		this.webClient.get().uri("/users/"+user.getUserId())
			.exchange()
			.expectStatus()
			.isOk();
		user.setName("Mr. coconut");
		this.webClient.post().uri("/users/"+user.getUserId())
			.body(BodyInserters.fromObject(user))
			.exchange()
			.expectStatus()
			.isOk();
	}

}
