package com.warehouse.service;

import com.warehouse.entity.Employee;
import com.warehouse.entity.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void printAllProducts(List<Product> products) {
    	for (Product p : products) {
    		System.out.println(p.toString());
    	}
    }

    @Override
    public void printAllProductsSortedByName(List<Product> products) {
    	products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
    	printAllProducts(products);
    }
    
    @Override
    public void printAllProductsSortedByPrice(List<Product> products) {
    	products.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));
    	printAllProducts(products);
    }
    
    @Override
    public void printAllProductsSortedByExpiresIn(List<Product> products) {
    	List<Product> sortedProducts = products.stream().sorted(Comparator.nullsLast(new ExpiresComparator())).collect(Collectors.toList());
    	printAllProducts(sortedProducts);
    }

    @Override
    public void printProduct(List<Product> products, int id, String productName) {
    	if (id != 0) {
    		for (Product p : products) {
    			if(id == p.getProduct_id()) {
    				System.out.println(p.toString());
    			}
    		}
    	} else if (productName != null) {
    		for (Product p : products) {
    			if (productName.equals(p.getName())) {
    				System.out.println(p.toString());
    			}
    		}
    	}
    }

    @Override
    public void printAllProductsWithPriceHigherThanCurrent(List<Product> products, Double price) {
    	for (Product p : products) {
    		if (p.getPrice().compareTo(price) >= 0) {
    			System.out.println(p.toString());
    		}
    	}
    }

    @Override
    public void printAllProductsWithPriceLowerThanCurrent(List<Product> products, Double price) {
    	for (Product p : products) {
    		if (p.getPrice().compareTo(price) < 0) {
    			System.out.println(p.toString());
    		}
    	}
    }

    @Override
    public void printAllProductsWithQuantityHigherThanCurrent(List<Product> products, Integer quantity) {
    	for (Product p : products) {
    		if (p.getQuantity().compareTo(quantity) >= 0) {
    			System.out.println(p.toString());
    		}
    	}
    }

    @Override
    public void printAllProductsWithQuantityLowerThanCurrent(List<Product> products, Integer quantity) {
    	for (Product p : products) {
    		if (p.getQuantity().compareTo(quantity) < 0) {
    			System.out.println(p.toString());
    		}
    	}
    }

    @Override
    public void addProduct(List<Product> products, Product product) {
    	products.add(product);
    }

    @Override
    public void changeProductPrice(List<Product> products, int productId, double price) {
        for (Product p : products) {
        	if (p.getProduct_id() == productId) {
        		p.setPrice(price);
        		break;
        	}
        }
    }

    @Override
    public void changeProductQuantity(List<Product> products, int productId, int quantity) {
    	for (Product p : products) {
        	if (p.getProduct_id() == productId) {
        		p.setQuantity(quantity);
        		break;
        	}
        }
    }

    @Override
    public void changeProductName(List<Product> products, int productId, String name) {
    	for (Product p : products) {
        	if (p.getProduct_id() == productId) {
        		p.setName(name);
        		break;
        	}
        }
    }

    @Override
    public void removeProduct(List<Product> products, int productId) {
    	for (Product p : products) {
        	if (p.getProduct_id() == productId) {
        		products.remove(p);
        		break;
        	}
        }
    }

    @Override
    public void printEmployeesSortedByName(List<Employee> employees) {
    	employees.sort((e1, e2) -> e1.getFirst_name().compareTo(e2.getFirst_name()));
    	printAllEmployees(employees);
    }
    
    @Override
	public void printEmployeesSortedBySalary(List<Employee> employees) {
    	employees.sort((e1, e2) -> e1.getSalary().compareTo(e2.getSalary()));
    	printAllEmployees(employees);		
	}

    @Override
    public void printMenu() {
        System.out.printf("What do you want ot do ? \n 1 print all products \n 2 print all products sorted by name " +
                "\n 3 print all sorted products by price \n 4 print all sorted date by expires in date \n 5 Printing certain products by ID or name " +
                " \n 6 printing all products with price equals or higher than price entered from the user \n " +
                "7 printing all products with price equals or lower than price entered from the user \n " +
                "8 Print all products with a quantity greater than or equal to the user defeat quantity \n " +
                "9 Print all products with quantity less than user specified quantity \n " +
                "10 Add a product\n " +
                "11 Change product price (by id) \n " +
                "12 Change product quantity (by id) \n" +
                "13 Change product name (by id) \n" +
                "14 Remove a product (by id) \n " +
                "15 Print employees sorted by name \n " + 
                "16 Print employees sorted by salary");
    }
    
    private void printAllEmployees(List<Employee> employees) {
    	for (Employee e : employees) {
    		System.out.println(e.toString());
    	}
    }
}
