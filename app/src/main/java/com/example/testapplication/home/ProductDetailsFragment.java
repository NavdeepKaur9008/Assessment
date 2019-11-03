package com.example.testapplication.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testapplication.R;
import com.example.testapplication.models.Product;

public class ProductDetailsFragment extends Fragment {

    public static final String TAG = "ProductDetailsFragment";
    private Product product;
    private ImageView prodImage;
    private TextView tvId, tvName, tvDescription, tvColors, tvRegularPrice, tvSalePrice;
    public ProductDetailsFragment() {
    }

    public static ProductDetailsFragment newInstance(Product product) {
        ProductDetailsFragment fragment = new ProductDetailsFragment();
        Bundle args = new Bundle();

        args.putParcelable("product", product);
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
        if(getArguments()!=null) {
            product = getArguments().getParcelable("product");
        }
        return inflater.inflate(R.layout.fragment_product_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prodImage = view.findViewById(R.id.img_product);
        tvName = view.findViewById(R.id.tv_prod_name);
        tvId = view.findViewById(R.id.tv_prod_id);
        tvDescription = view.findViewById(R.id.tv_prod_description);
        tvColors = view.findViewById(R.id.tv_prod_colors);
        tvSalePrice = view.findViewById(R.id.tv_prod_sale_price);
        tvRegularPrice = view.findViewById(R.id.tv_prod_regular_price);

        setProductDetails();
    }

    private void setProductDetails() {
        String resourceName =  product.getProductPhoto();
        int resourceId= getActivity().getResources().getIdentifier(resourceName, "drawable", getActivity().getPackageName());
        prodImage.setImageDrawable(getActivity().getResources().getDrawable(resourceId));

        tvId.setText("Id: " + product.getId());
        tvName.setText("Name: " + product.getName());
        tvDescription.setText("Description: " + product.getDescription());
        tvRegularPrice.setText("Regular Price: Rs." + product.getRegularPrice());
        tvSalePrice.setText("Sale Price: Rs." + product.getSalePrice());
        String colors="";
        for (String s: product.getColors()
             ) {
            colors= colors + " " + s;
        }
        tvColors.setText("Colors available: " + colors);

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
