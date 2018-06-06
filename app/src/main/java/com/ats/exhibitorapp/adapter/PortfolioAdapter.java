package com.ats.exhibitorapp.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ats.exhibitorapp.R;
import com.ats.exhibitorapp.activity.WebViewActivity;
import com.ats.exhibitorapp.model.Portfolio;

import java.util.ArrayList;
import java.util.List;

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.MyViewHolder> {

    private Context context;
    private List<Portfolio> portfolioList;
    private View itemView;
    private Activity activity;

    public PortfolioAdapter(Context context, List<Portfolio> portfolioList, Activity activity) {
        this.context = context;
        this.portfolioList = portfolioList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_portfolio, parent, false);

        return new PortfolioAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Portfolio portfolio =portfolioList.get(position);
        holder.tvMaterialTitle.setText("portfolio "+position);


        holder.tvMaterialTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                activity.startActivity(new Intent(context, WebViewActivity.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return portfolioList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMaterialTitle;
        public View view1;

        public MyViewHolder(View view) {
            super(view);
            tvMaterialTitle =  view.findViewById(R.id.tvMaterialTitle);
            view1 =  view.findViewById(R.id.view);
        }
    }



}
