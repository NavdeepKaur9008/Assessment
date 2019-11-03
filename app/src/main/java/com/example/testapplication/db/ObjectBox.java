package com.example.testapplication.db;

import android.content.Context;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class ObjectBox {
    private static BoxStore boxStore;

    public static void init(Context context) {
        boxStore = MyObjectBox.builder()
                .androidContext(context.getApplicationContext())
                .build();
    }

    public static BoxStore get() { return boxStore; }


    public static void save(ProductEntity product) {

        Box<ProductEntity> productEntityBox = ObjectBox.get().boxFor(ProductEntity.class);

        productEntityBox.put(product);
    }

    public static List<ProductEntity> fetchProducts() {
        Box<ProductEntity> productEntityBox = ObjectBox.get().boxFor(ProductEntity.class);
        return productEntityBox.getAll();
    }


}
