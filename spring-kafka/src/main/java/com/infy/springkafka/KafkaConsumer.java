package com.infy.springkafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer
{
//    @KafkaListener(topics = "myTopic",groupId = "group1")
//    public void consume(String message)
//    {
//    	log.info(String.format("Message Received %s", message));
//    }
    
    @KafkaListener(topics = "myTopic",groupId = "group1")
    public void consumeObject(UserDto userDto)
    {
    	log.info(String.format("Message Received %s", userDto.toString()));
    }
}
