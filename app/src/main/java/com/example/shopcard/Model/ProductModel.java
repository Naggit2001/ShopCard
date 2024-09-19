package com.example.shopcard.Model;

import java.sql.DataTruncation;

public class ProductModel {
    private  String name ;
    private  String description ;
    private  double price ;
    private  int imageResource;
    private  int id;


    public ProductModel(int id , String name, String description, double price, int imageResource) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResource = imageResource;
        this.id=id;
    }


    public int getId() { return id; }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResource() {
        return imageResource;
    }


}
