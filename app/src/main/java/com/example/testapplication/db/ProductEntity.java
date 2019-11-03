package com.example.testapplication.db;


import com.example.testapplication.db.converter.ColorsConverter;
import com.example.testapplication.db.converter.StoreConverter;

import java.util.List;
import java.util.Map;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class ProductEntity {
    @Id
    public long sno;

    private int id;

    private String name;

    private String description;

    private double regularPrice;

    private double salePrice;

    private String productPhoto;

    @Convert(converter = ColorsConverter.class, dbType = String.class)
    private List<String> colors;

    @Convert(converter = StoreConverter.class, dbType = String.class)
    private Map<String, String> store;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public void setStore(Map<String,String> store) {
        this.store = store;
    }

    public long getSno() {
        return sno;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public String getProductPhoto() {
        return productPhoto;
    }

    public List<String> getColors() {
        return colors;
    }

    public Map<String, String> getStore() {
        return store;
    }
}
