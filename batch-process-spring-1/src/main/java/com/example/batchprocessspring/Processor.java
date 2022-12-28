package com.example.batchprocessspring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
@Component
public class Processor implements ItemProcessor<User, User>
{
	private static final Map<Integer, String> NAMES = new HashMap<>();
	
	  public Processor() {
       NAMES.put(1, "PEN");
       NAMES.put(2, "BOOK");
       NAMES.put(3, "BAG");
       NAMES.put(4, "DRESS");
       NAMES.put(5, "MOBILE");
       
	}
	@Override
	public User process(User user) throws Exception {
      String name = NAMES.get(user.getName());
      user.setName(name);
      return user;
	}
   
}
