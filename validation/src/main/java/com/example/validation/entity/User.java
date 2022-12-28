package com.example.validation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User 
{
	@Id
	@GeneratedValue
   private Integer id;
   private String name;
   private String email;
   private String mobile;
   private String gender;
   private Integer age;
   private String nationality;
   
}
