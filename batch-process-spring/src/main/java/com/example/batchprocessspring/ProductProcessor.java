package com.example.batchprocessspring;

import org.springframework.batch.item.ItemProcessor;

public class ProductProcessor implements ItemProcessor<Product, Product>
{

	@Override
	public Product process(Product product) throws Exception 
	{
		Double cost = product.getCost();
		product.setCost(cost * 12/100.0);
		product.setGst(cost * 22/100.0);
		return product;
	}

}
