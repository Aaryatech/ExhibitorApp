package com.ats.exhibitorapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ats.exhibitorapp.R;
import com.ats.exhibitorapp.model.Products;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductsAdapter extends  RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {

    private ArrayList<Products> productList;
    private Context context;

    public ProductsAdapter(ArrayList<Products> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_products, parent, false);

        return new ProductsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Products products=productList.get(position);

        holder.tvProductName.setText(products.getProdName());
        holder.tvProductExperty.setText(products.getProdExperty());

        try {
            Picasso.get().load(products.getProdImage1())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.ivProduct);
        } catch (Exception e) {
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvProductName, tvProductExperty;
        public ImageView ivProduct;

        public MyViewHolder(View view) {
            super(view);
            tvProductName = view.findViewById(R.id.tvProductName);
            tvProductExperty = view.findViewById(R.id.tvProductExperty);
            ivProduct = view.findViewById(R.id.ivProduct);
        }
    }

}
