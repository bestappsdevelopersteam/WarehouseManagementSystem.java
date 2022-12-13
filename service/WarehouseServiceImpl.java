package com.warehouse.service;

import com.warehouse.entity.Customer;
import com.warehouse.entity.Employee;
import com.warehouse.entity.Product;
import com.warehouse.entity.Warehouse;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static com.sun.tools.javac.util.StringUtils.toLowerCase;

public class WarehouseServiceImpl implements WarehouseService {
	
	private static final String CUSTOMER_CHOOSE_OPTION = "customer";
	private static final String EMPLOYEE_CHOOSE_OPTION = "employee";
	
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private CustomerService customerService = new CustomerServiceImpl();
    private FileOrganizatorService fileOrganizatorService = new FileOrganizatorServiceImpl();
    private WarehouseMenuSelector warehouseMenuSelector = new WarehouseMenuSelectorImpl();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void loginInWarehouse() throws FileNotFoundException {
        Warehouse warehouse = buildWarehouse();
        
        System.out.println("Welcome to our Shop! Are you Customer Or Employee?");
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("customer") && !input.equalsIgnoreCase("employee")) {
            System.out.println("Invalid input! Please write Customer Or Employee:");
            input = sc.nextLine();
        }
        
        selectOptions(input, warehouse);
    }
    
    private Warehouse buildWarehouse() {
    	System.out.println("Enter file name to upload the information for employee");
        String fileName1 = sc.nextLine().toLowerCase();

        while (!fileName1.equalsIgnoreCase("employee.csv")) {
            System.out.println("Invalid input! Please write employee.csv :");
            fileName1 = sc.nextLine().toLowerCase();

        }
        List<Employee> employees = (List<Employee>)(fileOrganizatorService.readFile(fileName1, true));

        System.out.println("Enter file name to upload the information for products");
        String fileName2 = sc.nextLine().toLowerCase();

        while (!fileName2.equalsIgnoreCase("products.csv")) {
            System.out.println("Invalid input! Please write products.csv :");

            fileName2 = sc.nextLine().toLowerCase();
        }
        List<Product> products = (List<Product>)(fileOrganizatorService.readFile(fileName2, false));

        return new Warehouse(products, employees);
    }
    
    private void selectOptions(String input, Warehouse warehouse) {
    	Customer customer = new Customer();
    	boolean isNeedToBeRepeat = true;
        while (isNeedToBeRepeat) {
        	processMenu(input);
        	if (CUSTOMER_CHOOSE_OPTION.equalsIgnoreCase(input)) {
        		System.out.println("Enter option number: ");
        		String optionNumber = sc.nextLine();
        		validateInput(optionNumber, false);
        		warehouseMenuSelector.selectOption(Integer.parseInt(optionNumber), false, warehouse, customer);
        		isNeedToBeRepeat = isNeedToBeRepeat(true);
        	} else {
        		System.out.println("Enter option number: ");
        		String optionNumber = sc.nextLine();
        		validateInput(optionNumber, true);
        		warehouseMenuSelector.selectOption(Integer.parseInt(optionNumber), true, warehouse, null);
        		isNeedToBeRepeat = isNeedToBeRepeat(false);
        	}
        }
        
        fileOrganizatorService.writeProductsIntoFile(warehouse.getProducts());
    }

    private void processMenu(String option) {
        switch (option) {
            case CUSTOMER_CHOOSE_OPTION:
                customerService.printMenu(); break;
            case EMPLOYEE_CHOOSE_OPTION:
                employeeService.printMenu();
        }
    }
    
    private boolean isNeedToBeRepeat(boolean isCustomer) {
    	if (isCustomer) {
    		System.out.println("Do you want to exit from the menu? (Y/N)");
    		String input = sc.nextLine();
    		if ("Y".equalsIgnoreCase(input)) {
    			return false;
    		}
    	} else {
    		System.out.println("Do you want to save the products? (Y/N)");
    		String input = sc.nextLine();
    		if ("Y".equalsIgnoreCase(input)) {
    			return false;
    		}    		
    	}
    	return true;
    }
    
    public boolean validateInput(String input, boolean isEmployee) {
		try {
			if (isEmployee) {
				int commandNumber = Integer.parseInt(input);
				if (commandNumber < 1 || commandNumber > 16) {
					System.out.println("Invalid command! Try again! The input must be number between 1 and 16 ");
					return false;
				}
			} else {
		        int commandNumber = Integer.parseInt(input);
		        if (commandNumber < 1 || commandNumber > 5) {
		            System.out.println("Invalid command! Try again! The input must be number between 1 and 5 ");
		            return false;
		        }
			}
			
            return true;
        } catch (Exception NumberFormatException) {
            System.out.println("Invalid command! Try again!");
            return false;
        }
	}
}
