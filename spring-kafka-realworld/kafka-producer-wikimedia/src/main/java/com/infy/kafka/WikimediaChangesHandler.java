package com.infy.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WikimediaChangesHandler implements EventHandler
{
	
	private KafkaTemplate<String, String> template;
	private String topic;
	
	public WikimediaChangesHandler(KafkaTemplate<String, String> template, String topic) {
		super();
		this.template = template;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		log.info(String.format("Event data: %s",messageEvent.getData()));
		template.send(topic,messageEvent.getData());
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
