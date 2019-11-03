package com.example.testapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("regularPrice")
    private double regularPrice;

    @SerializedName("salePrice")
    private double salePrice;

    @SerializedName("productPhoto")
    private String productPhoto;

    @SerializedName("colors")
    private List<String> colors;

    @SerializedName("stores")
    private Map<String, String> stores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public Map<String, String> getStores() {
        return stores;
    }

    public void setStores(Map<String, String> stores) {
        this.stores = stores;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeDouble(this.regularPrice);
        dest.writeDouble(this.salePrice);
        dest.writeString(this.productPhoto);
        dest.writeStringList(this.colors);
        dest.writeInt(this.stores.size());
        for (Map.Entry<String, String> entry : this.stores.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeString(entry.getValue());
        }
    }

    public Product() {
    }

    protected Product(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.regularPrice = in.readDouble();
        this.salePrice = in.readDouble();
        this.productPhoto = in.readString();
        this.colors = in.createStringArrayList();
        int storesSize = in.readInt();
        this.stores = new HashMap<String, String>(storesSize);
        for (int i = 0; i < storesSize; i++) {
            String key = in.readString();
            String value = in.readString();
            this.stores.put(key, value);
        }
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
