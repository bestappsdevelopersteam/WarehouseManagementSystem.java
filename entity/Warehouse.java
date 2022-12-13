package com.warehouse.entity;

import java.util.List;

public class Warehouse {

    private List<Product> products;
    private List<Employee> employees;

    public Warehouse() {

    }

    public Warehouse(List<Product> products, List<Employee> employees) {
        this.products = products;
        this.employees = employees;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public static Warehouse parseDataToObject(String [] inputEmployees, String [] inputProducts) {
        return null;

    }
}
