package br.josets.amqplistenerexample;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class AmqpProjectionConfig {

	public static final String QUEUE_NAME = "user-pojo-queue";
//
//	@Autowired
//	private ObjectMapper jacksonObjectMapper;
//	
	@Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
	
	@Bean
    public Queue userQueue() {
       return new Queue(QUEUE_NAME);
    }
	
	// can use this way if the auto converter doesnt work
//	@RabbitListener(queues = QUEUE_NAME)
//	public void processOrder(Message message) throws JsonParseException, JsonMappingException, IOException {
//		User readValue = jacksonObjectMapper.readValue(message.getBody(), User.class);
//		System.out.println("########################### >>> Received from annotated component: " + readValue);
//    }
	
	
	//if used from the rabbit web console, must pass the `Properties` with 'content_type' = 'application/json' value
	@RabbitListener(queues = QUEUE_NAME)
	public void processUserMessage(User readValue) {
		System.out.println("########################### >>> Received from annotated component: " + readValue);
    }
	
}
