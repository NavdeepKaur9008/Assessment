package com.example.testapplication.home;

import com.example.testapplication.models.Product;
import com.example.testapplication.utils.AppConstants;
import com.google.gson.Gson;

import org.json.JSONArray;

public class ProductCreater {

//    static int productId = 1;

    public  Product create(int productId) {
        Product product = getProduct(productId);
        return product;
    }

    private Product getProduct(int productId)
    {
        Product product = null;
        try {
            JSONArray jsonArray = new JSONArray(AppConstants.json);
            product = new Gson().fromJson(jsonArray.getString(productId), Product.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return product;
    }
}
