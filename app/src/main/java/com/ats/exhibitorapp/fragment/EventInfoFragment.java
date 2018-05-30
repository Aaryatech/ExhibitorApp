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
import com.ats.exhibitorapp.model.FeedbackQuestionModel;

import java.util.ArrayList;

public class EventInfoFragment extends Fragment implements View.OnClickListener {

    private LinearLayout llFloorMap, llEnquiry, llFeedback;
    private ImageView ivEventImage;
    private TextView tvEventName, tvEventDate, tvEventPlace, tvEventDesc, tvEventContactPerson, tvEventMobile, tvEventEmail;

    public static ArrayList<FeedbackQuestionModel> quetionList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_info, container, false);
        getActivity().setTitle("Event");

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

        FeedbackQuestionModel model1 = new FeedbackQuestionModel(1, "Innovation");
        FeedbackQuestionModel model2 = new FeedbackQuestionModel(2, "Information Delivery");
        FeedbackQuestionModel model3 = new FeedbackQuestionModel(3, "Presentation");
        FeedbackQuestionModel model4 = new FeedbackQuestionModel(4, "Ue of Technology");

        quetionList.clear();
        quetionList.add(model1);
        quetionList.add(model2);
        quetionList.add(model3);
        quetionList.add(model4);


        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.llFloorMap) {

        } else if (v.getId() == R.id.llEnquiry) {
            Fragment adf = new VisitorSearchFragment();
            Bundle args = new Bundle();
            args.putInt("eventId", 1);
            args.putString("type", "Enquiry");
            adf.setArguments(args);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, adf, "EventDetailFragment").commit();
        } else if (v.getId() == R.id.llFeedback) {
            Fragment adf = new VisitorSearchFragment();
            Bundle args = new Bundle();
            args.putInt("eventId", 1);
            args.putString("type", "Feedback");
            adf.setArguments(args);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, adf, "EventDetailFragment").commit();
        }
    }
}
