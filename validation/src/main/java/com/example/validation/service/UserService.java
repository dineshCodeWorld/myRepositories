package com.example.validation.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.validation.dto.UserDto;
import com.example.validation.entity.User;
import com.example.validation.repository.UserRepository;

@Service
@Transactional
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(UserDto userDto)
	{
		User user = User.builder()
				        .name(userDto.getName())
				        .email(userDto.getEmail())
				        .age(userDto.getAge())
				        .gender(userDto.getGender())
				        .nationality(userDto.getNationality())
				        .mobile(userDto.getMobile())
				        .build();
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	public User getById(Integer id)
	{
		return userRepository.findById(id).get();
	}

}
