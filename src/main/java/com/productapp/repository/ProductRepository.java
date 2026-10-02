package com.productapp.repository;

import com.productapp.entity.Product;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	//List<Product> findByCategoryIgnoreCase(String category);
	List<Product> findByCategory(String category);
	
	//find products between a price 
	List<Product> findByPriceBetween(double min, double max);
	
	//find in-stock products
	List<Product> findByQuantityGreaterThan(int quantity);
	
	//out-of stock
	List<Product> findByQuantity(int quantity);
	
	//low stock 
	List<Product> findByQuantityLessThan(int quantity);
	
	//count product by category
	long countByCategory(String category);
}