package com.ats.exhibitorapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ats.exhibitorapp.R;
import com.ats.exhibitorapp.activity.HomeActivity;
import com.ats.exhibitorapp.fragment.EventInfoFragment;
import com.ats.exhibitorapp.fragment.EventsFragment;
import com.ats.exhibitorapp.model.EventModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {

    private ArrayList<EventModel> eventList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvDateTime, tvPlace;
        public ImageView imageView;
        public LinearLayout llEvent;

        public MyViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tvName);
            tvDateTime = view.findViewById(R.id.tvDate);
            tvPlace = view.findViewById(R.id.tvPlace);
            imageView = view.findViewById(R.id.imageView);
            llEvent = view.findViewById(R.id.linearLayout);
        }
    }

    public EventsAdapter(ArrayList<EventModel> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_events, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final EventModel model = eventList.get(position);
        Log.e("Adapter : ", " model : " + model);

        holder.tvName.setText(model.getEventName());
        holder.tvPlace.setText(model.getEventLocation());
        holder.tvDateTime.setText(model.getEventFromDate() + " to " + model.getEventToDate() + " " + model.getToTime());

        try {
            Picasso.get().load(model.getEventLogo())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.imageView);
        } catch (Exception e) {
        }


        holder.llEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HomeActivity activity = (HomeActivity) context;

                Fragment adf = new EventInfoFragment();
                Bundle args = new Bundle();
                args.putInt("eventId", model.getEventId());
                adf.setArguments(args);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, adf, "EventsFragment").commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }


}
