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
import com.ats.exhibitorapp.adapter.EventsAdapter;
import com.ats.exhibitorapp.model.EventModel;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    private RecyclerView recyclerView;

    private EventsAdapter adapter;
    private ArrayList<EventModel> eventList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        EventModel model1 = new EventModel(1, "Auto Expo", "1/5/2018", "31/5/2018", "Nashik", "");
        EventModel model2 = new EventModel(2, "MWC", "1/5/2018", "31/5/2018", "Nashik", "");

        eventList.add(model1);
        eventList.add(model2);

        adapter = new EventsAdapter(eventList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        return view;
    }

}
