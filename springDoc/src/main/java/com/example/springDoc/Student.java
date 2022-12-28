package com.example.springDoc;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student
{
   private Long id;
   private String name;

public Student(Long id,String name) {
	super();
	this.id = id;
	this.name = name;
}

public Long getId() {
	return id;
}

public String getName()
{
  return name;	
}
   
}
