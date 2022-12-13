package com.warehouse.entity;

public class Employee {

    private int employee_id;
    private String first_name;
    private String last_name;
    private int age;
    private Double salary;

    public Employee () {

    }

    public Employee(int employee_id, String first_name, String last_name, int age, double salary) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.salary = salary;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
    	return "id: " + employee_id + " first name: " 
    			+ first_name + " last name: " + last_name + " age: " 
    			+ age + " salary: " + salary;
    }
    
    public static Employee createEmployee(String[] attributes) {
        int employeeId = Integer.parseInt(attributes[0]);
        String firstName = attributes[1];
        String lastName = attributes[2];
        int age = Integer.parseInt(attributes[3]);
        double salary = Double.parseDouble(attributes[4]);

        return new Employee(employeeId, firstName, lastName, age, salary);
    }
}