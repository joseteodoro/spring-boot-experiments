package com.example.amqpredisexample.amqp;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import com.example.amqpredisexample.model.AskForFood;

//@Component
//@EnableRabbit
public class AmqpListener {

//	@Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
	
//	@RabbitListener(queues = AmqpConfig.QUEUE_ANSWER)
	public void processUserMessage(AskForFood readValue) {
		System.out.println("########################### >>> Received from annotated component: " + readValue);
    }
	
}
