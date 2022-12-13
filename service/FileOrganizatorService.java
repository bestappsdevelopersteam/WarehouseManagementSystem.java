package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.Product;

public interface FileOrganizatorService {
	
	List<?> readFile(String name, boolean isEmployeeFile);
	
	void writeProductsIntoFile(List<Product> products);
}
