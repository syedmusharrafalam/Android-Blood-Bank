package com.bloodbank.navigator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bloodbank.R;

/**
 * Created by User on 4/22/2018.
 */

public class HomeFragement extends Fragment {
View v;
    RecyclerView recyclerViewHome;
    public HomeFragement() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     v=inflater.inflate(R.layout.home_fragment, container, false);
        recyclerViewHome=(RecyclerView)v.findViewById(R.id.homeRecycler);
        return v;
    }

}
