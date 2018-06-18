package br.josets.amqpexample;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AMQPSender {

	@Autowired
	AmqpTemplate template;
	
	public void send(Object obj) {
		this.template.convertAndSend(AmqpConfig.queueName, obj.toString());
	}
	
}
