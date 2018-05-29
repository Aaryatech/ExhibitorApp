package com.ats.exhibitorapp.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ats.exhibitorapp.R;

public class VisitorSearchFragment extends Fragment implements View.OnClickListener {

    private EditText edSearchText;
    private Button btnSearch;
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visitor_search, container, false);

        edSearchText = view.findViewById(R.id.edSearchText);
        btnSearch = view.findViewById(R.id.btnSearch);
        fab = view.findViewById(R.id.fab);

        btnSearch.setOnClickListener(this);
        fab.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSearch) {

        } else if (v.getId() == R.id.fab) {

        }
    }
}
