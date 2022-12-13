package com.warehouse.service;

import java.util.Comparator;

import com.warehouse.entity.Product;

public class ExpiresComparator implements Comparator<Product> {

    @Override
    public int compare(final Product p1, final Product p2) {
    	if (p1.getExpires_in() == null) {
    		return -1;
    	}
    	
    	if (p2.getExpires_in() == null) {
    		return 1;
    	}
        return p1.getExpires_in().compareTo(p2.getExpires_in());
    }
}
