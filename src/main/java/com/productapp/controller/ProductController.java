package com.productapp.controller;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // CREATE
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // READ ALL
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    
    //READ BY category
    @GetMapping("/category/{category}")
    public List<Product> getProduct(@PathVariable String category) {
		return productService.getProductByCategory(category);
    }
    
    //READ BY price range
    @GetMapping("/price")
    public List<Product> getByPriceRange(@RequestParam double min, @RequestParam double max) {
        return productService.getProductsByPriceRange(min, max);
    }
    
    
    @GetMapping("/in-stock")
    public List<Product> getInStockProducts() {
        return productService.getInStockProducts();
    }
    
    @GetMapping("/out-of-stock")
    public List<Product> getOutOfStockProducts() {
        return productService.getOutOfStockProducts();
    }
    
    
    @GetMapping("/low-stock")
    public List<Product> getLowStockProducts(){
    	return productService.getLowStockProducts();
    }
    
    // total count
    @GetMapping("/count")
    public long getTotalCount() {
        return productService.getTotalProductCount();
    }

    // count by category
    @GetMapping("/count/category/{category}")
    public long getCountByCategory(@PathVariable String category) {
        return productService.getProductCountByCategory(category);
    }
    
    // UPDATE
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully!";
    }
}