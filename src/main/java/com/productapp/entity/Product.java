package com.productapp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Basic Info
    private String name;
    private String description;
    private String category;

    // Pricing
    private double price;
    private double discount;
    private double finalPrice;

    // Quantity / Stock
    private int quantity;

    // Packaging
    private double weight;
    private String unit;

    // Dates
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;

    // ---------------- Business Logic ----------------

    public void setPrice(double price) {
        this.price = price;
        calculateFinalPrice();
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        calculateFinalPrice();
    }

    private void calculateFinalPrice() {
        this.finalPrice = price - (price * discount / 100);
    }

    // ---------------- Getters & Setters ----------------

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }

    public double getDiscount() { return discount; }

    public double getFinalPrice() { return finalPrice; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public LocalDate getManufacturingDate() { return manufacturingDate; }
    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}