package com.example.springhateoas;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class User extends RepresentationModel<User>
{
  private Integer userId;
  private String name;
  
  @JsonCreator
public User(@JsonProperty("userId") int userId,@JsonProperty("name") String name) {
	super();
	this.userId = userId;
	this.name = name;
}
  
}
