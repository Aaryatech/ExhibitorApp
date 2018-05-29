package com.ats.exhibitorapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.ats.exhibitorapp.R;

public class EnquiryFragment extends Fragment implements View.OnClickListener {

    private TextView tvDate, tvTime;
    private RadioButton rbAnyday, rbNextWeek, rbNextToNextWeek, rbTime1, rbTime2, rbTime3, rbTime4;
    private Button btnSubmit;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enquiry, container, false);

        tvDate = view.findViewById(R.id.tvDate);
        tvTime = view.findViewById(R.id.tvTime);

        rbAnyday = view.findViewById(R.id.rbAnyday);
        rbNextWeek = view.findViewById(R.id.rbNextWeek);
        rbNextToNextWeek = view.findViewById(R.id.rbNextToNextWeek);
        rbTime1 = view.findViewById(R.id.rbTime1);
        rbTime2 = view.findViewById(R.id.rbTime2);
        rbTime3 = view.findViewById(R.id.rbTime3);
        rbTime4 = view.findViewById(R.id.rbTime4);

        btnSubmit = view.findViewById(R.id.btnSubmit);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmit) {

        }
    }
}
