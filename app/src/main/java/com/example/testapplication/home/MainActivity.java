package com.example.testapplication.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.testapplication.R;
import com.example.testapplication.db.ObjectBox;
import com.example.testapplication.db.ProductEntity;
import com.example.testapplication.models.Product;

import io.objectbox.Box;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Button btCreateProd1,btCreateProd2,btCreateProd3, btShowProd;
    private int addProductRequest = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        setClickListeners();
    }

    private void setViews() {
        btCreateProd1 = findViewById(R.id.bt_create_prod1);
        btCreateProd2 = findViewById(R.id.bt_create_prod2);
        btCreateProd3 = findViewById(R.id.bt_create_prod3);
        btShowProd = findViewById(R.id.bt_show_prod);
    }

    private void setClickListeners() {
        btCreateProd1.setOnClickListener(this);
        btCreateProd2.setOnClickListener(this);
        btCreateProd3.setOnClickListener(this);
        btShowProd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_create_prod1:
                createNewProduct(0);
                break;

            case R.id.bt_create_prod2:
                createNewProduct(1);
                break;

            case R.id.bt_create_prod3:
                createNewProduct(2);
                break;

            case R.id.bt_show_prod:
                showProductList();
                break;
            default:
                Log.e(TAG, "default");
        }
    }

    private void createNewProduct(int productId) {

        int prodNum=productId+1;
        Toast.makeText(this, "Product " + prodNum + " added", Toast.LENGTH_SHORT).show();
        Product product = new ProductCreater().create(productId);
        ProductEntity persistableEntity = getPersistableEntity(product);
        ObjectBox.save(persistableEntity);

    }

    private ProductEntity getPersistableEntity(Product prod) {
        ProductEntity entity = new ProductEntity();

        entity.setName(prod.getName());
        entity.setId(prod.getId());
        entity.setDescription(prod.getDescription());
        entity.setProductPhoto(prod.getProductPhoto());
        entity.setRegularPrice(prod.getRegularPrice());
        entity.setSalePrice(prod.getSalePrice());
        entity.setColors(prod.getColors());
        entity.setStore(prod.getStores());

        return entity;
    }


    private void showProductList() {

        if (ObjectBox.fetchProducts().isEmpty()) {
            Toast.makeText(this, "No Product added", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(this, ProductActivity.class));
        }

    }
}
