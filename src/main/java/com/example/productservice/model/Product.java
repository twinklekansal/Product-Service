package com.example.productservice.model;

public class Product {

    private long id;
    private String name;
    private double price;
    private double sellingPrice;

    //constructor
    public Product(long id, String name, double price, double sellingPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sellingPrice = sellingPrice;
        //this.discount = ((price - sellingPrice) / price) * 100;

    }

    //getters and setters
    public long getId() {
        return id; }
    public void setId(long id) {
        this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getDiscount() {
        return (((price - sellingPrice) / price) * 100) ;

    }

}

