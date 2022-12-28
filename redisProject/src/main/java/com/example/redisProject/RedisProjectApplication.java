package com.example.redisProject;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.redisProject.entity.Product;
import com.example.redisProject.repository.ProductRepo;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class RedisProjectApplication {
	
	@Autowired
	private ProductRepo productRepo;
	
	@PostMapping()
	public Product save(@RequestBody Product product)
	{
		return productRepo.save(product);
	}
	
	@GetMapping()
	public List<Product> getAllProducts()
	{
		return productRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id)
	{
		return productRepo.findProductById(id);
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id)
	{
		return productRepo.delete(id);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RedisProjectApplication.class, args);
	}
	


}
