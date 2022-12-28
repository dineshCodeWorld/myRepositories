package com.example.springneo4j.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springneo4j.entity.User;
import com.example.springneo4j.repository.UserRepo;

@Service
public class Services 
{
	@Autowired
	private UserRepo userRepo;

	public Collection<User> getAll()
	{
		return userRepo.findAll();
	}

}
