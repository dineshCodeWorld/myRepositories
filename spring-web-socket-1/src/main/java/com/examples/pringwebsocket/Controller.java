package com.examples.pringwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

@org.springframework.stereotype.Controller
public class Controller 
{
	@MessageMapping("/chat.newUser")
	@SendTo("/topic/javainuse")
	public ChatMessage newUser(@Payload ChatMessage chatMessage,SimpMessageHeaderAccessor headerAccessor)
	{
		 headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		 return chatMessage;
	}
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/javainuse")
  public ChatMessage sendMessage(@Payload ChatMessage chatMessage)
  {
	  return chatMessage;
  }
	

}
