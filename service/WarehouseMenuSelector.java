package com.warehouse.service;

import com.warehouse.entity.Customer;
import com.warehouse.entity.Warehouse;

public interface WarehouseMenuSelector {
    void selectOption(int optionNumber, boolean isEmployee, Warehouse warehouse, Customer customer);
}
