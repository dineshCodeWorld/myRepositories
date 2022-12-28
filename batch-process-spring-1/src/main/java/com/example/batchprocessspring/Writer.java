package com.example.batchprocessspring;

import java.util.List;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Writer implements ItemWriter<User>
{
	@Autowired
	private Repository repository;

	@Override
	public void write(Chunk<? extends User> chunk) throws Exception {
       repository.saveAll(chunk);
	}
    

}
