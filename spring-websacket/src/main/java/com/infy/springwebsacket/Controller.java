package com.infy.springwebsacket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@org.springframework.stereotype.Controller
public class Controller 
{
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
   public Greeting greeting(HelloMessage message)
   {
	   return new Greeting("Hello " +HtmlUtils.htmlEscape(message.getName()));
   }
}
