package com.infy.teslapro.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDto 
{
	   private Long userId;
		@NotNull(message = "name should not null")
	   private String firstName;
		@NotNull(message = "name should not null")
	   private String lastName;
		@Email(message = "please enter a avlid email")
	   private String email;
}

