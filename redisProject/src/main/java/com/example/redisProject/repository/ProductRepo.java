package com.example.redisProject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.example.redisProject.entity.Product;

@Repository
public class ProductRepo 
{
	@Autowired
   private RedisTemplate redisTemplate;
   public static final String HASH_KEY = "product";
   
   public Product save(Product product)
   {
	   redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
	   return product;
   }
   
   public List<Product> findAll()
   {
	   return redisTemplate.opsForHash().values(HASH_KEY);
   }
   
   public Product findProductById(int id)
   {
	   return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
   }
   
   public String delete(int id)
   {
	    redisTemplate.opsForHash().delete(HASH_KEY, id);
	   return "product deleted";
   }
}
