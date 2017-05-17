package com.zeptsoft.myshopping.core.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeptsoft.myshopping.R;

/**
 * Created by SSBook on 15/05/17.
 */

public class ListListFragment extends Fragment {

    private AddButtonAnimator animator;
    private FloatingActionButton addButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.list_list_fragment_layout,container, false);
        initLayout(view);

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initLayout(View view){
        addButton = (FloatingActionButton) view.findViewById(R.id.list_add);
        this.animator = new AddButtonAnimator()

        view.findViewById(R.id.list_add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               view.findViewById()
            }
        });

    }

    public ListListFragment getInstance(){
        return new ListListFragment();
    }
}
