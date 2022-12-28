package com.infy.teslapro.service;

import java.util.List;

import com.infy.teslapro.dto.ChangeRoleDto;
import com.infy.teslapro.dto.DeleteDto;
import com.infy.teslapro.dto.PasswordDto;
import com.infy.teslapro.dto.UpdateDto;
import com.infy.teslapro.dto.UserDto;
import com.infy.teslapro.dto.UserResponse;
import com.infy.teslapro.entity.User;
import com.infy.teslapro.exception.UserNotFoundException;


public interface UserService {

	Boolean register(UserDto userDto) throws UserNotFoundException;

	List<UserResponse> getAllUsersList() throws UserNotFoundException;

    String updateProfile(UpdateDto updateDto) throws UserNotFoundException;

	String deleteUser(DeleteDto deleteDto) throws UserNotFoundException;

	User findByEmail(String email);

    String validateToken(String token) throws UserNotFoundException;

    String resendToken(DeleteDto deleteDto) throws UserNotFoundException;

	String resetPassword(PasswordDto passwordDto) throws UserNotFoundException;

	String validatePasswordResetToken(String token) throws UserNotFoundException;

	String changePassword(PasswordDto passwordDto) throws UserNotFoundException;

	String changeRole(ChangeRoleDto changeRoleDto) throws UserNotFoundException;

	User getByName(String name);

}
