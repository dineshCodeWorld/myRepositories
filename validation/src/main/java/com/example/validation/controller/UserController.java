package com.example.validation.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.validation.dto.UserDto;
import com.example.validation.entity.User;
import com.example.validation.service.UserService;

@RestController
public class UserController 
{
	@Autowired
	private UserService userService;
	@PostMapping("/addUser")
	public User addUser(@RequestBody @Valid UserDto userDto)
	{
		return userService.saveUser(userDto);
	}
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	@GetMapping("/getUserById/{id}")
	public User getById(@PathVariable Integer id)
	{
		return userService.getById(id);
	}

}
