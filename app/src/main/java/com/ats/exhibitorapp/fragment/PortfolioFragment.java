package com.ats.exhibitorapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ats.exhibitorapp.R;
import com.ats.exhibitorapp.adapter.PortfolioAdapter;
import com.ats.exhibitorapp.model.Portfolio;

import java.util.ArrayList;
import java.util.List;

public class PortfolioFragment extends Fragment {

    private RecyclerView rvPortfolio;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  view = inflater.inflate(R.layout.fragment_portfolio,container,false);

        rvPortfolio=view.findViewById(R.id.rvPortfolio);


        List<Portfolio> portfolioList=new ArrayList<>();

        Portfolio portfolio=new Portfolio();
        portfolioList.add(portfolio);
        portfolioList.add(portfolio);
        portfolioList.add(portfolio);
        portfolioList.add(portfolio);

        PortfolioAdapter portfolioAdapter=new PortfolioAdapter(getContext(),portfolioList,getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvPortfolio.setLayoutManager(mLayoutManager);
        rvPortfolio.setItemAnimator(new DefaultItemAnimator());
        rvPortfolio.setAdapter(portfolioAdapter);

        return view;

    }

}
