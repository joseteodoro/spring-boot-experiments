package com.example.amqpredisexample.amqp;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

//@Component
public class AmqpConfig {

	public static final String QUEUE_ASK = "ask-for-food-queue";
	
	public static final String QUEUE_ANSWER = "answer-for-food-queue";

//	@Bean
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost", 5672);
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }

//    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(rabbitConnectionFactory());
    }

//    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(rabbitConnectionFactory());
    }

}
