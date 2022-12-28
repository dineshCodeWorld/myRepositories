package com.examples.pringwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class EventListener 
{
  @Autowired
  private SimpMessageSendingOperations messageSendingOperations;
  
//  @org.springframework.context.event.EventListener
//  public void handleWebSocketConnectionListener()
//  {
//	  System.out.println("Received a new web socket connection");
//  }
  
  @org.springframework.context.event.EventListener
  public void handleWebSocketDisconnectListener(SessionDisconnectEvent event)
  {
	  StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
	  
	 String username = (String) headerAccessor.getSessionAttributes().get("username");
	  
	  if(username!=null)
	  {
		  ChatMessage chatMessage = new ChatMessage();
		  chatMessage.setType("LEAVE");
		  chatMessage.setSender(username);
		  messageSendingOperations.convertAndSend("/topic/public",chatMessage);
	  }
  }
}
