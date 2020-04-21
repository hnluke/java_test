package com.eshore.pojo;

import java.io.Serializable;

public class Product implements Serializable{
    
    private final static long serialVersionUID = 100L;
    
    private String id;
    private String name;
    private double price;
    private String info; 
    
    public Product() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
