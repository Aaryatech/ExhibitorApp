package com.ats.exhibitorapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ats.exhibitorapp.R;
import com.ats.exhibitorapp.adapter.ProductsAdapter;
import com.ats.exhibitorapp.model.Products;

import java.util.ArrayList;
import java.util.List;


public class ProductsFragment extends Fragment {

    private ArrayList<Products>productsList=new ArrayList<>();

    private RecyclerView rvProducts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products, container, false);


        rvProducts=view.findViewById(R.id.rvProducts);

        Products  products=new Products();
        products.setExhId(1);
        products.setProdName("prod name1");
        products.setProdExperty("expert 1");

        productsList.add(products);

        products=new Products();
        products.setExhId(1);
        products.setProdName("prod name2 ");
        products.setProdExperty("expert 2");


        productsList.add(products);

        ProductsAdapter productsAdapter= new ProductsAdapter(productsList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvProducts.setLayoutManager(mLayoutManager);
        rvProducts.setItemAnimator(new DefaultItemAnimator());
        rvProducts.setAdapter(productsAdapter);



        return view;
    }

}
