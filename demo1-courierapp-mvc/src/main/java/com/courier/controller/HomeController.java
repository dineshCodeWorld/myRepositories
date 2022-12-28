package com.courier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController 
{
  @GetMapping("/index")
  public String showHomePage()
  {
	  return "index";
  }
  
  @GetMapping("/logout")
  public String showLogOut()
  {
	  return "index";
  }
}
