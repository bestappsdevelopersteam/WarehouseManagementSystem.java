package com.warehouse.service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.warehouse.entity.Employee;
import com.warehouse.entity.Product;

public class FileOrganizatorServiceImpl implements FileOrganizatorService {
	private static final String CSV_SEPARATOR = ",";
	private static final String RESOURCE_PATH = "resource/";

	@Override
	public List<?> readFile(String name, boolean isEmployeeFile) {
		if (isEmployeeFile) {
			return getEmployees(name);
		}
		return getProducts(name);
	}
	
	@Override
	public void writeProductsIntoFile(List<Product> products) {
		try {
			FileWriter fileWriter = new FileWriter(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss")) + ".csv");
            for (Product product : products) {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(product.getProduct_id() <=0 ? "" : product.getProduct_id());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getName().trim().length() == 0? "" : product.getName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getPrice() < 0 ? "" : product.getPrice());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getQuantity() <= 0 ? "" : product.getQuantity());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getType().trim().length() == 0 ? "" : product.getType());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getColor().trim().length() == 0 ? "" : product.getColor());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getExpires_in() == null ? "" : product.getExpires_in().toString());
                fileWriter.write(oneLine.toString());
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        	System.out.println("An error occurred.");
        }
	}
	
	private List<Employee> getEmployees(String fileName) {
        List<Employee> employees = new ArrayList<>();
        Path pathToFile = Paths.get(RESOURCE_PATH + "employee.csv");
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(CSV_SEPARATOR, 6);
                Employee employee = Employee.createEmployee(attributes);
                employees.add(employee);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }
	
	private List<Product> getProducts(String fileName) {
        List<Product> products = new ArrayList<>();
        Path pathToFile = Paths.get(RESOURCE_PATH + fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(CSV_SEPARATOR, 7);
                Product product = Product.createProduct(attributes);
                products.add(product);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return products;
    }
}
