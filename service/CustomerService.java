package com.warehouse.service;

import com.warehouse.entity.Product;
import com.warehouse.entity.ShoppingBasket;

import java.util.List;

public interface CustomerService {

    void printAllProducts(List<Product> products);

    void searchProductByCategory(String category, List<Product> products);

    void searchProductByName(String name, List<Product> products);

    void addProductToShoppingBasket(int productId, List<Product> products, int quantity, ShoppingBasket shoppingBasket);

    void calculateShoppingBasketPrice(ShoppingBasket shoppingBasket);

    void printMenu();
}
