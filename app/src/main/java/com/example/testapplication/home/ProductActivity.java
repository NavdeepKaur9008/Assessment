package com.example.testapplication.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.testapplication.R;
import com.example.testapplication.adapters.ProductAdapter;
import com.example.testapplication.models.Product;
import com.example.testapplication.utils.AppConstants;

public class ProductActivity extends AppCompatActivity implements ProductAdapter.onImageClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        openFragment(AppConstants.FRAGMENT_LIST, null, null);
    }

    private void openFragment(String fragmentType, String imageName, Product product){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if(fragmentType.equals(AppConstants.FRAGMENT_LIST)){
            ft.add(R.id.fragment_container, ProductListFragment.newInstance(), ProductListFragment.TAG);
            ft.addToBackStack(ProductListFragment.TAG);

        } else if(fragmentType.equals(AppConstants.FRAGMENT_IMAGE)){
            ft.replace(R.id.fragment_container, ImageViewFragment.newInstance(imageName), ImageViewFragment.TAG);
            ft.addToBackStack(ImageViewFragment.TAG);
        } else {
            ft.replace(R.id.fragment_container, ProductDetailsFragment.newInstance(product), ProductDetailsFragment.TAG);
            ft.addToBackStack(ProductDetailsFragment.TAG);

        }
        ft.commit();

    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() ==1) {
            finish();
        } else{
            super.onBackPressed();
        }
    }

    @Override
    public void onImageClicked(String imageName) {
        openFragment(AppConstants.FRAGMENT_IMAGE, imageName, null);
    }

    @Override
    public void onCardClicked(Product product) {
        openFragment(AppConstants.FRAGMENT_DETAILS, null, product);
    }
}
