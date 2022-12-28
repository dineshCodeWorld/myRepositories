package com.infy.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumerDb 
{
	@Autowired
	private ConsumerRepo repository;
	
    @KafkaListener(topics = "topic2",groupId = "group1")
    public void consumeMessages(String message)
    {
    	log.info(String.format("Message Recieved %s", message));
    	WikimediaEntity entity = new WikimediaEntity();
    	entity.setWikimediaData(message);
    	repository.save(entity);
    }
}
