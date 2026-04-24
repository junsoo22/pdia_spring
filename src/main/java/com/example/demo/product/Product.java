package com.example.demo.product;


public class Product {

    private String name;
    private int price;
    private int priceByDollar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceByDollar() {
        return priceByDollar;
    }

    public void setPriceByDollar(int priceByDollar) {
        this.priceByDollar = priceByDollar;
    }
}
