package com.infy.springkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller 
{
  @Autowired
  private KafkaProducer producer;
  
  @GetMapping("/publish/{message}")
  public ResponseEntity<String> sendMessage(@PathVariable String message)
  {
	  producer.sendMessage(message);
	  return ResponseEntity.ok("Message Sent Sussfully");
  }
  
  @PostMapping("/publish")
  public ResponseEntity<String> senndObjectMessage(@RequestBody UserDto userDto)
  {
	  producer.sendObject(userDto);
	  return ResponseEntity.ok("object Message Sent Sussfully");
  }
}
