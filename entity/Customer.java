package com.warehouse.entity;

public class Customer {

    private ShoppingBasket shoppingBasket = new ShoppingBasket();

    public Customer() {

    }

    public Customer(ShoppingBasket shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }

    public ShoppingBasket getShoppingBasket() {
        return shoppingBasket;
    }

    public void setShoppingBasket(ShoppingBasket shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }
}
