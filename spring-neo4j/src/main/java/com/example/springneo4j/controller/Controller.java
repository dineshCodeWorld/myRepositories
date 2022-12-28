package com.example.springneo4j.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springneo4j.entity.User;
import com.example.springneo4j.service.Services;

@RestController
public class Controller 
{
  @Autowired
  private Services services;
  
  @GetMapping("/user/getAll")
  public Collection<User> getAll()
  {
	  return services.getAll();
  }
}
