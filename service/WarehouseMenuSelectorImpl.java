package com.warehouse.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.warehouse.entity.Customer;
import com.warehouse.entity.Product;
import com.warehouse.entity.ShoppingBasket;
import com.warehouse.entity.Warehouse;

public class WarehouseMenuSelectorImpl implements WarehouseMenuSelector {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private CustomerService customerService = new CustomerServiceImpl();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void selectOption(int optionNumber, boolean isEmployee, Warehouse warehouse, Customer customer) {
    	List<Product> products = warehouse.getProducts();
        if (isEmployee) {

            switch (optionNumber) {
                case 1: employeeService.printAllProducts(products); break;
                case 2: employeeService.printAllProductsSortedByName(products); break;
                case 3: employeeService.printAllProductsSortedByPrice(products); break;
                case 4: employeeService.printAllProductsSortedByExpiresIn(products); break;
                case 5: printProduct(products); break;
                case 6: printAllProductsByPrice(products, true); break;
                case 7: printAllProductsByPrice(products, false); break;
                case 8: printAllProductsByQuantity(products, true); break;
                case 9: printAllProductsByQuantity(products, false); break;
                case 10: addProduct(products); break;
                case 11: changeProduct(products, true, false, false); break;
                case 12: changeProduct(products, false, true, false); break;
                case 13: changeProduct(products, false, false, true); break;
                case 14: removeProduct(products); break;
                case 15: employeeService.printEmployeesSortedByName(warehouse.getEmployees()); break;
                case 16: employeeService.printEmployeesSortedBySalary(warehouse.getEmployees()); break;
            }
        } else {
            switch (optionNumber) {
                case 1: customerService.printAllProducts(products); break;
                case 2: searchProduct(products, false, true); break;
                case 3: searchProduct(products, true, false); break;
                case 4: addProductToShoppingBasket(products, customer.getShoppingBasket()); break;
                case 5: customerService.calculateShoppingBasketPrice(customer.getShoppingBasket()); break;
            }
        }
    }

    private void printProduct(List<Product> products) {
    	System.out.println("Enter product id: ");
    	int productId = sc.nextInt();
    	System.out.println("Enter product name: ");
    	String name = sc.nextLine();
    	
    	employeeService.printProduct(products, productId, name);    	
    }
    
    private void printAllProductsByPrice(List<Product> products, boolean isPriceHigher) {
    	System.out.println("Enter product price: ");
    	double price = sc.nextDouble();
    	if (isPriceHigher) {
    		employeeService.printAllProductsWithPriceHigherThanCurrent(products, price);
    	} else {
    		employeeService.printAllProductsWithPriceLowerThanCurrent(products, price);
    	}
    }
    
    private void printAllProductsByQuantity(List<Product> products, boolean isQuantityHigher) {
    	System.out.println("Enter product quantity: ");
    	int quantity = sc.nextInt();
    	if (isQuantityHigher) {
    		employeeService.printAllProductsWithQuantityHigherThanCurrent(products, quantity);
    	} else {
    		employeeService.printAllProductsWithQuantityLowerThanCurrent(products, quantity);
    	}
    }
    
    private void addProduct(List<Product> products) {
    	System.out.println("Enter product name: ");
    	String name = sc.nextLine();
    	System.out.println("Enter product price: ");
    	double price = sc.nextDouble();
    	System.out.println("Enter product quantity: ");
    	int quantity = sc.nextInt();
    	System.out.println("Enter product type: ");
    	String type = sc.nextLine();
    	System.out.println("Enter product color: ");
    	String color = sc.nextLine();
    	System.out.println("Enter expires in (format - d/MM/yyyy): ");
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    	String input = sc.nextLine();
    	LocalDate expiresIn = LocalDate.parse(input, formatter);
     
    	employeeService.addProduct(products, new Product(products.size() + 2, name, price, quantity, type, color, expiresIn));
    }
    
    private void changeProduct(List<Product> products, boolean isPriceChanged, boolean isQuantityChanged, boolean isNameChanged) {
    	System.out.println("Enter product id: ");
    	String productId = sc.nextLine();
    	
    	if (isPriceChanged) {
    		System.out.println("Enter product price: ");
        	String price = sc.nextLine();
    		employeeService.changeProductPrice(products, Integer.parseInt(productId), Double.parseDouble(price));
    	} else if (isQuantityChanged) {
    		System.out.println("Enter product quantity: ");
        	String quantity = sc.nextLine();
    		employeeService.changeProductQuantity(products, Integer.parseInt(productId), Integer.parseInt(quantity));
    	} else if (isNameChanged) {
    		System.out.println("Enter product name: ");
        	String name = sc.nextLine();
    		employeeService.changeProductName(products, Integer.parseInt(productId), name);
    	}
    }
    
    private void removeProduct(List<Product> products) {
    	System.out.println("Enter product id: ");
    	String productId = sc.nextLine();
    	
    	employeeService.removeProduct(products, Integer.parseInt(productId));
    }
    
    private void searchProduct(List<Product> products, boolean isSearchedByName, boolean isSearchedByCategory) {
    	if (isSearchedByCategory) {
    		System.out.println("Enter product type: ");
        	String type = sc.nextLine();
        	customerService.searchProductByCategory(type, products);
    	} else if (isSearchedByName) {
    		System.out.println("Enter product name: ");
        	String name = sc.nextLine();
        	customerService.searchProductByName(name, products);
    	}
    }
    
    private void addProductToShoppingBasket(List<Product> products, ShoppingBasket shoppingBasket) {
    	System.out.println("Enter product id: ");
    	String productId = sc.nextLine();
    	System.out.println("Enter product quantity: ");
    	String quantity = sc.nextLine();
    	
    	customerService.addProductToShoppingBasket(Integer.parseInt(productId), products, Integer.parseInt(quantity), shoppingBasket);
    }
}
