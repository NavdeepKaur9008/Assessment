package com.example.testapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.R;
import com.example.testapplication.home.ProductListFragment;
import com.example.testapplication.models.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

        private ArrayList<Product> productList;
        private Context context;
        private onImageClickListener listener;

        public ProductAdapter(ArrayList<Product> productList, Context context) {
            this.productList = productList;
            this.context = context;
        }

        public void setListener(Context context) {
            this.listener = (onImageClickListener) context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item_product, parent, false);
            return new MyViewHolder(view, listener, productList);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tvName.setText(productList.get(position).getName());
            holder.tvId.setText(productList.get(position).getId() + "");
            holder.tvDescription.setText(productList.get(position).getDescription());
            holder.tvRegularPrice.setText(productList.get(position).getRegularPrice() + "");
            holder.tvSalePrice.setText(productList.get(position).getSalePrice() + "");
            String resourceName = productList.get(position).getProductPhoto();
            int resourceId= context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
            holder.imgProduct.setImageDrawable(context.getResources().getDrawable(resourceId));
        }

        @Override
        public int getItemCount() {
            return productList.size();
        }


        public static class MyViewHolder extends RecyclerView.ViewHolder {
            private Context context;
            private CardView productCard;
            private ImageView imgProduct;
            private onImageClickListener listener;
            private ArrayList<Product> productList;
            private TextView labelName, labelId, labelDescription, labelRegPrice, labelSalePrice;
            private TextView tvName, tvId, tvDescription, tvRegularPrice, tvSalePrice;
            public MyViewHolder(View v, onImageClickListener listener, ArrayList<Product> productList) {
                super(v);
                this.listener = listener;
                this.productList= productList;
                productCard = v.findViewById(R.id.product_details_card);
                labelName = v.findViewById(R.id.label_name);
                labelId=v.findViewById(R.id.label_id);
                labelDescription= v.findViewById(R.id.label_description);
                labelRegPrice = v.findViewById(R.id.regular_price);
                labelSalePrice = v.findViewById(R.id.label_sale_price);

                tvName = v.findViewById(R.id.name);
                tvId = v.findViewById(R.id.id);
                tvDescription = v.findViewById(R.id.description);
                tvRegularPrice = v.findViewById(R.id.regular_price);
                tvSalePrice = v.findViewById(R.id.sale_price);

                imgProduct = v.findViewById(R.id.img_product);
                setClickListener();


            }

            private void setClickListener() {

                imgProduct.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        String imageName = productList.get(position).getProductPhoto();
                        listener.onImageClicked(imageName);

                    }
                });

                productCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        listener.onCardClicked(productList.get(position));

                    }
                });

            }
        }

        public interface onImageClickListener {
            void onImageClicked(String imageName);
            void onCardClicked(Product product);
    }


}
