package com.productapp.service;

import com.productapp.entity.Product;
import com.productapp.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // CREATE
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // READ ALL
    public List<Product> getAllProducts() {
    	//System.out.println(productRepository.findAll());
        return productRepository.findAll();
    }

    // READ BY ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    // UPDATE
    public Product updateProduct(Long id, Product product) {
        Product existing = getProductById(id);

        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setCategory(product.getCategory());
        existing.setPrice(product.getPrice());
        existing.setDiscount(product.getDiscount());
        existing.setQuantity(product.getQuantity());
        existing.setWeight(product.getWeight());
        existing.setUnit(product.getUnit());
        existing.setManufacturingDate(product.getManufacturingDate());
        existing.setExpiryDate(product.getExpiryDate());

        return productRepository.save(existing);
    }

    // DELETE
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}