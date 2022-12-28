package com.infy.springkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaProducer 
{
	@Autowired
    private KafkaTemplate<String, String> template;
	@Autowired
	private KafkaTemplate<String, UserDto> templateObject;


	public void sendMessage(String message)
	{
		template.send("myTopic",message);
		log.info(String.format("Message Sent %s",message ));
	}
	
	public void sendObject(UserDto userDto)
	{
		Message<UserDto> message = MessageBuilder.withPayload(userDto).setHeader(KafkaHeaders.TOPIC, "myTopic").build();
		
		templateObject.send(message);
		log.info(String.format("Object Message Sent %s",message));
	}
}
