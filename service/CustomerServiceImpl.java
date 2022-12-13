package com.warehouse.service;

import com.warehouse.entity.Product;
import com.warehouse.entity.ShoppingBasket;
import com.warehouse.exception.ProductQuantityMissingException;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void printAllProducts(List<Product> products) {
        for (Product p : products) {
        	if (p.getQuantity() >= 1) {
        		System.out.println(p.toString());
        	}
        }
    }

    @Override
    public void searchProductByCategory(String category, List<Product> products) {
        for (Product p : products) {
        	if (p.getType().equals(category)) {
        		System.out.println(p.toString());
        	}
        }
    }

    @Override
    public void searchProductByName(String name, List<Product> products) {
        for (Product p : products) {
        	if (p.getName().contains(name)) {
        		System.out.println(p.toString());
        	}
        }
    }

    @Override
    public void addProductToShoppingBasket(int productId, List<Product> products, int quantity, ShoppingBasket shoppingBasket) {
    	for (Product p : products) {
    		if (p.getProduct_id() == productId && p.getQuantity() >= quantity) {
    			shoppingBasket.getProducts().add(new Product(p.getProduct_id(), p.getName(), p.getPrice(), quantity, p.getType(), p.getColor(), p.getExpires_in()));
    			p.setQuantity(p.getQuantity() - quantity);
    		} else if (p.getProduct_id() == productId && p.getQuantity() < quantity) {
    			throw new ProductQuantityMissingException();
    		}
    	}
    }

    @Override
    public void calculateShoppingBasketPrice(ShoppingBasket shoppingBasket) {
        double totalPrice = 0;
        for (Product p : shoppingBasket.getProducts()) {
        	totalPrice += p.getPrice() * p.getQuantity();
        }
        
        System.out.println("Total price of shopping basket is: " + totalPrice);
    }

    @Override
    public void printMenu() {
        System.out.printf("What do you want ot do ? \n 1 print all products \n 2 Searching product by category \n 3 Searching product by name" +
                "\n 4 Add product to basket \n 5 Price calculation");
    }

}
