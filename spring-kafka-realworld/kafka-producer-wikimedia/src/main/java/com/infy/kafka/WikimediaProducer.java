package com.infy.kafka;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WikimediaProducer 
{
	@Autowired
   private KafkaTemplate<String, String> template;
   
   public void sendMessage() throws InterruptedException
   {
	   String topic = "topic2";
	   
	   EventHandler eventHandler = new WikimediaChangesHandler(template, topic);
	   String url = "https://stream.wikimedia.org/v2/stream/recentchange";
	   EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
	   EventSource eventSource = builder.build();
	   
	   eventSource.start();
	   TimeUnit.MINUTES.sleep(10);
   }
}
