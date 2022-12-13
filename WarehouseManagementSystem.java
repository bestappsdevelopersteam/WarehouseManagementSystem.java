package com.warehouse;

import java.io.FileNotFoundException;

import com.warehouse.service.WarehouseService;
import com.warehouse.service.WarehouseServiceImpl;

public class WarehouseManagementSystem {
	
    public static void main(String[] args) throws FileNotFoundException {
    	WarehouseService warehouseService = new WarehouseServiceImpl();
    	warehouseService.loginInWarehouse();
    }

}
