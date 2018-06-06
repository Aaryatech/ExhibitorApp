package com.ats.exhibitorapp.adapter;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.ats.exhibitorapp.R;
import com.ats.exhibitorapp.model.MapData;
import com.ats.exhibitorapp.model.RouteDetails;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by ATS on 02/05/17.
 */

public class RouteListAdapter extends RecyclerView.Adapter<RouteListAdapter.MyViewHolder> {

    private Context context;
    private List<RouteDetails> routeList;
    View itemView;
    Activity activity;
    public static int count = 0;
    ArrayList<PendingIntent> intentArray = new ArrayList<PendingIntent>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvStopName, tvTime;
        public ImageView ivReminder, ivStop;
        public View view1;

        public MyViewHolder(View view) {
            super(view);
            tvStopName =  view.findViewById(R.id.tvStopName);
            tvTime =  view.findViewById(R.id.tvTime);
            view1 =  view.findViewById(R.id.view);
        }
    }


    public RouteListAdapter(List<RouteDetails> routeList, Context context, Activity activity) {
        this.routeList = routeList;
        this.context = context;
        this.activity = activity;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_route_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RouteDetails routeDetails = routeList.get(position);
        holder.tvStopName.setText(routeDetails.getStopName());
        holder.tvTime.setText(routeDetails.getTime());


        if (position == routeList.size() - 1) {
            holder.view1.setVisibility(View.INVISIBLE);
        }




    }

    @Override
    public int getItemCount() {
        return routeList.size();
    }
}
