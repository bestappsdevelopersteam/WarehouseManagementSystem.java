# WarehouseManagementSystem.java

warehouse
Second module project Store We want to build software to run in a store.

There will be two types of users in the system - employees and ordinary customers. When starting the program (after loading the data, which is explained below in the task description), the user is given the option to choose what they want to use it as. Each employee has a unique employee_id . Each product has a unique product_id . Customer information is not stored.

The system can read the goods from . csv file and parse them to java objects that can be manipulated. The data for the categories are saved in separate files, the path to which must be entered when starting the program. For the purpose of this project we will work with two types of . csv file, the structure of which will be as follows:

Product details:
product_id, name, price, quantity, type, color, expires_in

Example file: id, name, price, quantity, type, color, expiration_date 1,oranges,0.10,500,food,,06-07-2021 2,toilet paper,2.50,150,sanitary,, 3,lipstick,6.80,15,makeup,red,04-02-2025 4,dog leash,10.30,6,others,blue,

The types of products are as follows: • food _ _ • Drinks _ _ • sanitary _ _ • makeup _ _ • decoration, others

It is important to note that different product categories have different characteristics and structure.

Employee details: employee_id, first_name, last_name, age, salary

Example file: employee_id, first_name, last_name, age, salary 1, Ivan, Ivanov, 45,550 2, Maria, Ivanova, 22,450 3,Angel,Petkov,50,750

After the user opens the program, he is given the option to type in the file names from which the product and employee information will be read. Once these are loaded into the program, the user is given the option to log in as an employee or continue as a customer.

Login as an employee: • The system prompts the employee to enter their id and name • In the event of a failed login, the user is prompted again to enter their details until a successfully entered combination • Upon successful login (an employee with such data exists in the system), the employee is presented with the option of choosing from a menu of options • The system should enable the following operations: • Print all products • Print all products sorted by: o name o price o expiration date (for products that have one, the ones that expire soonest compared to today's date are printed first) • Print specific product (by id , name) • Print all products with a price greater than or equal to a user-specified price • Print all products with a price lower than the price set by the user • Print all products with a quantity greater than or equal to a user-specified quantity • Print all products with a quantity less than a user-specified quantity • Add a product • Change the price of a product (by id ) • Change the quantity of a product (by id ) • Change product name (by id ) • Delete a product (by id , the ids of the other products do not need to change in this action) • Sort employees by: o name o salary After the employee has finished working on the products, they should be able to “ save ”, where the new list of products is saved to a new file named timestamp.csv, where timestamp is the exact time the document was saved.

Login as a customer: • Print all available products (with a quantity of at least 1) • Search for a product by category • Search for a product by name (both full match and partial) • Add to user's basket by correctly supplied product_id and quantity (if the desired quantity of products is not available, display an error message) • Calculation of the final price based on all products in the basket

After the user "buys" his products (we do not implement payment functionality), the data in . csv files need to be updated. The new list of products is saved to a new file named timestamp.csv, where timestamp is the exact time the document was saved.
