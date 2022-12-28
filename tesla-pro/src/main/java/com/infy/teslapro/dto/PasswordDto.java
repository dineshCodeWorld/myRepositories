package com.infy.teslapro.dto;

import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordDto 
{
	@Email(message = "please enter a avlid email")
  private String email;
  private String oldPassword;
  private String newPassword;
}