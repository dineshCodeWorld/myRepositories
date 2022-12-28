package com.infy.kafka;

import java.sql.Blob;
import java.sql.Clob;

import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WikimediaEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
	@Lob
   private String WikimediaData;
   
}
