package br.josets.amqpexample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AmqpExampleApplication {

	public static void main(String[] args) {
		// SpringApplication.run(AmqpExampleApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(AmqpExampleApplication.class);
		AMQPSender template = context.getBean(AMQPSender.class);
		template.send("this is my wonderfull message! Take a look!");
		System.exit(0);
	}
}
