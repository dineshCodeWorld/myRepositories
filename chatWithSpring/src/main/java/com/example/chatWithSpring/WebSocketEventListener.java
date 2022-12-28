package com.example.chatWithSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener
{
	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
	
	@Autowired
   private SimpMessageSendingOperations messageSendingOperations;
	
	@EventListener
	public void handleWebSocketConnectionListener(SessionConnectEvent event)
	{
		logger.info("Received a new web socket connection");
	}
	
	@EventListener
	public void handlerWebSocketDisconnectListener(SessionDisconnectEvent event)
	{
		SimpMessageHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		
		String username = (String) headerAccessor.getSessionAttributes().get("username");
		
		if(username!=null)
		{
			logger.info("User Disconnected :" + username);
			ChatMessagePojo chatMessagePojo = new ChatMessagePojo();
			chatMessagePojo.setType(ChatMessagePojo.MessageType.LEAVE);
			chatMessagePojo.setSender(username);
			messageSendingOperations.convertAndSend("/topic/public",chatMessagePojo);
		}
	}
}
