package com.ats.exhibitorapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ats.exhibitorapp.R;
import com.ats.exhibitorapp.model.FeedbackQuestionModel;

import java.util.ArrayList;

public class FeedbackQuestionFragment extends Fragment {

    private TextView tvQuestion;
    private RatingBar ratingBar;
    private EditText edRemark;

    private FeedbackQuestionModel question;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static ArrayList<FeedbackQuestionModel> quetionList = new ArrayList<>();
    public static int index = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback_question, container, false);

        tvQuestion = view.findViewById(R.id.tvQuestion);
        ratingBar = view.findViewById(R.id.ratingBar);
        edRemark = view.findViewById(R.id.edRemark);

        final int index = getArguments().getInt(ARG_SECTION_NUMBER);

        try {
            question = quetionList.get(index - 1);
            if (question != null) {
                tvQuestion.setText("" + question.getQuestion());
            }

        } catch (Exception e) {
        }

        return view;
    }

    public static FeedbackQuestionFragment newInstance(int sectionNumber) {
        FeedbackQuestionFragment fragment = new FeedbackQuestionFragment();
        Bundle args = new Bundle();
        index = sectionNumber;
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

}
