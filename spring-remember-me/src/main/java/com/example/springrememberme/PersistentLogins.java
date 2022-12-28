package com.example.springrememberme;

import java.time.LocalDate;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@jakarta.persistence.Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersistentLogins 
{
	@NotNull
	@Max(64)
   private String username;
  // @jakarta.persistence.Id
   @NotNull
   @Max(64)
   private String series;
   @NotNull
   @Max(64)
   private String token;
   @NotNull
   private LocalDate lastUsed = LocalDate.now();
}
