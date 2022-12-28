package com.infy.teslapro.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.infy.teslapro.dto.ChangeRoleDto;
import com.infy.teslapro.dto.DeleteDto;
import com.infy.teslapro.dto.PasswordDto;
import com.infy.teslapro.dto.UpdateDto;
import com.infy.teslapro.dto.UserDto;
import com.infy.teslapro.dto.UserResponse;
import com.infy.teslapro.entity.User;
import com.infy.teslapro.event.RegistrationCompleteEvent;
import com.infy.teslapro.exception.UserNotFoundException;
import com.infy.teslapro.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@Validated
@CrossOrigin(origins = {"http://localhost:4200","http://127.0.0.1:4200","http://localhost:8081","http://127.0.0.1:8081"})
public class UserController
{
	@Autowired
	private UserService userService;
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

//	@GetMapping("transaction.htm")
//	public String transaction(ModelMap map)
//	{
//		UserDto userDto = new UserDto();
//		map.addAttribute("transaction",userDto);
//		return "register";
//	}
	
	@PostMapping("/register")
	public String register(@RequestBody @Valid UserDto userDto,final HttpServletRequest request) throws UserNotFoundException
	{
		if(!(userDto.getFirstName().equalsIgnoreCase("null")||userDto.getLastName().equalsIgnoreCase("null"))){
	    Boolean	response = userService.register(userDto);
	    if(response) {
	    	User user = userService.findByEmail(userDto.getEmail());
	    	applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request) ));
		    return "verificatin link sent to your mail";
	    }return "user alrady registered";
		}return "invalid name";
	}
	
	private String applicationUrl(HttpServletRequest request) {
        return "http://"+ request.getServerName() +":"+request.getServerPort() + request.getContextPath();
	}
	
	@GetMapping("/validateToken")
	public String validateToken(@RequestParam("token") String token) throws UserNotFoundException
	{
		return userService.validateToken(token);
	}
	
//-------------------------------------------------------------------	
	
	@PostMapping("/resendToken")
	public String resendToken(@RequestBody @Valid DeleteDto deleteDto) throws UserNotFoundException
	{
		return userService.resendToken(deleteDto);
	}
	
//-------------------------------------------------------------------	
	@PostMapping("/resetPassword")
	public String resetPassword(@RequestBody @Valid PasswordDto passwordDto) throws UserNotFoundException
	{
		return userService.resetPassword(passwordDto);
	}
	@GetMapping("/validatePasswordResetToken")
	public String validatePasswordResetToken(@RequestParam("token") String token) throws UserNotFoundException
	{
		return userService.validatePasswordResetToken(token);
	}
	
//-------------------------------------------------------------------	
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestBody @Valid PasswordDto passwordDto) throws UserNotFoundException
	{
		return userService.changePassword(passwordDto);
	}
	
//-------------------------------------------------------------------	
	
//	@GetMapping("userList.htm")
//	public String report(ModelMap map)
//	{
//		UserResponse userResponse = new UserResponse();
//		map.addAttribute("", userResponse);
//		return "/userList";
//	}
	
	@GetMapping("/getUserList")
	public List<UserResponse> getAllUsersList() throws UserNotFoundException
	{
		return userService.getAllUsersList();
	}
	
	@PutMapping("/updateProfile")
	public String updateProfile(@RequestBody @Valid UpdateDto updateDto) throws UserNotFoundException
	{
		return userService.updateProfile(updateDto);
	}
	@PostMapping("/deleteUser")
	public String deleteUser(@RequestBody @Valid DeleteDto deleteDto) throws UserNotFoundException
	{
		return  userService.deleteUser(deleteDto);
	}
//----------------------------------------------------------------------------
	
	@PostMapping("/changeUserRole")
	public String changeRole(@RequestBody @Valid ChangeRoleDto changeRoleDto) throws UserNotFoundException
	{
		return userService.changeRole(changeRoleDto);
	}
	
	@GetMapping("/getByName")
	public User getUserByName(@RequestParam("name")@NonNull String name)
	{
		return userService.getByName(name);
	}
}