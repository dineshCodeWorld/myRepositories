package com.example.batchprocessspring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product 
{
  private Long id;
  private String name;
  private Double cost;
  private Double discount;
  private Double gst;
}
