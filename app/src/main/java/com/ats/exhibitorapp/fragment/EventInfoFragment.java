package com.ats.exhibitorapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ats.exhibitorapp.R;

public class EventInfoFragment extends Fragment implements View.OnClickListener {

    private LinearLayout llFloorMap, llEnquiry, llFeedback;
    private ImageView ivEventImage;
    private TextView tvEventName, tvEventDate, tvEventPlace, tvEventDesc, tvEventContactPerson, tvEventMobile, tvEventEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_info, container, false);

        llFloorMap = view.findViewById(R.id.llFloorMap);
        llEnquiry = view.findViewById(R.id.llEnquiry);
        llFeedback = view.findViewById(R.id.llFeedback);

        ivEventImage = view.findViewById(R.id.ivEventImage);

        tvEventName = view.findViewById(R.id.tvEventName);
        tvEventDate = view.findViewById(R.id.tvEventDate);
        tvEventPlace = view.findViewById(R.id.tvEventPlace);
        tvEventDesc = view.findViewById(R.id.tvEventDesc);
        tvEventContactPerson = view.findViewById(R.id.tvEventContactPerson);
        tvEventMobile = view.findViewById(R.id.tvEventMobile);
        tvEventEmail = view.findViewById(R.id.tvEventEmail);

        llFeedback.setOnClickListener(this);
        llEnquiry.setOnClickListener(this);
        llFloorMap.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.llFloorMap) {

        } else if (v.getId() == R.id.llEnquiry) {

        } else if (v.getId() == R.id.llFeedback) {

        }
    }
}
