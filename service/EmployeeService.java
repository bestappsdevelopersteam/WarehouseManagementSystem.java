package com.warehouse.service;

import com.warehouse.entity.Product;
import com.warehouse.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void printAllProducts(List<Product> products);

    void printAllProductsSortedByName(List<Product> products);
    
    void printAllProductsSortedByPrice(List<Product> products);

    void printAllProductsSortedByExpiresIn(List<Product> products);

    void printProduct(List<Product> products, int id, String productName);

    void printAllProductsWithPriceHigherThanCurrent(List<Product> products, Double price);

    void printAllProductsWithPriceLowerThanCurrent(List<Product> products, Double price);

    void printAllProductsWithQuantityHigherThanCurrent(List<Product> products, Integer quantity);

    void printAllProductsWithQuantityLowerThanCurrent(List<Product> products, Integer quantity);

    void addProduct(List<Product> products, Product product);

    void changeProductPrice(List<Product> products, int productId, double price);

    void changeProductQuantity(List<Product> products, int productId, int quantity);

    void changeProductName(List<Product> products, int productId, String name);

    void removeProduct(List<Product> products, int productId);

    void printEmployeesSortedByName(List<Employee> employees);
    
    void printEmployeesSortedBySalary(List<Employee> employees);

    void printMenu();
}
