package com.warehouse.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product {

    private int product_id;
    private String name;
    private Double price;
    private Integer quantity;
    private String type;
    private String color;
    private LocalDate expires_in;

    public Product() {

    }

    public Product(int product_id, String name, Double price, int quantity, String type, String color, LocalDate expires_in) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.color = color;
        this.expires_in = expires_in;

    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(LocalDate expires_in) {
        this.expires_in = expires_in;
    }
    
    @Override
    public String toString() {
    	return "id: " + product_id + " name: " + name 
    			+ " price: " + price + " quantity: " + quantity + " type: " 
    			+ type + " color: " + color + " expires in: " + expires_in;
    }
    
    public static Product createProduct(String[] attributes) {
        int productId = Integer.parseInt(attributes[0]);
        String name = attributes[1];
        Double price = Double.parseDouble(attributes[2]);
        int quantity = Integer.parseInt(attributes[3]);
        String type = attributes[4];
        String color = attributes[5];
        LocalDate expiresIn = null;
        if (attributes[6] != null && !attributes[6].isEmpty()) {
        	expiresIn = LocalDate.parse(attributes[6], DateTimeFormatter.ofPattern("d/MM/yyyy"));
        }
              
        return new Product(productId, name, price, quantity, type, color, expiresIn);
    }
}
