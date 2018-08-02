package com.kurobarabenjamingeorge.mynavigationdrawer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kurobarabenjamingeorge.mynavigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabTwoFragment extends Fragment {


    public TabTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_two, container, false);
    }

}
