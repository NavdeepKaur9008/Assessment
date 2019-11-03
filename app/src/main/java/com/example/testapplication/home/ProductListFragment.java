package com.example.testapplication.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapplication.R;
import com.example.testapplication.adapters.ProductAdapter;
import com.example.testapplication.db.ObjectBox;
import com.example.testapplication.db.ProductEntity;
import com.example.testapplication.models.Product;

import org.json.JSONArray;

import java.util.ArrayList;

import io.objectbox.Box;

public class ProductListFragment extends Fragment {
    private androidx.recyclerview.widget.RecyclerView productRecyclerView;
    private ProductAdapter adapter;
    private ArrayList<Product> productList;

    public static final String TAG = "ProductListFragment";
    public ProductListFragment() {
    }
    public static ProductListFragment newInstance() {
        ProductListFragment fragment = new ProductListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productRecyclerView = view.findViewById(R.id.recycler_view_product_list);
        productRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        productRecyclerView.setLayoutManager(layoutManager);
        productList = new ArrayList<>();
        adapter = new ProductAdapter(productList, getContext());
        adapter.setListener(getActivity());
        productRecyclerView.setAdapter(adapter);
        getProductsFromDb();


    }
    private void getProductsFromDb() {
        try {
            for (ProductEntity product : ObjectBox.fetchProducts()) {
                Product p = new Product();

                p.setName(product.getName());
                p.setId(product.getId());
                p.setSalePrice(product.getSalePrice());
                p.setRegularPrice(product.getRegularPrice());
                p.setDescription(product.getDescription());
                p.setProductPhoto(product.getProductPhoto());
                p.setColors(product.getColors());
                p.setStores(product.getStore());

                productList.add(p);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
