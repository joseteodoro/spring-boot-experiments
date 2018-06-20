package br.josets.foodserviceexample.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.josets.foodserviceexample.model.UserOrder;

@Component
public class AMQPSender {

	@Autowired
	AmqpTemplate template;
	
	@Autowired
	private ObjectMapper jacksonObjectMapper;
	
	public void send(UserOrder order) throws JsonProcessingException {
		String json = jacksonObjectMapper.writeValueAsString(order);
		this.template.convertAndSend(AmqpConfig.QUEUE_NAME, json);
	}
	
}
