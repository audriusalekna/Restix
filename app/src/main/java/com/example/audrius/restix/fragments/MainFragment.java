package com.example.audrius.restix.fragments;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.audrius.restix.R;
import com.example.audrius.restix.Services.DataService;
import com.example.audrius.restix.activities.MainActivity;
import com.example.audrius.restix.adapters.BarAdapter;
import com.example.audrius.restix.adapters.CafeeAdapter;
import com.example.audrius.restix.adapters.RestAdapter;
import com.example.audrius.restix.adapters.RestourantAdapter;
import com.example.audrius.restix.objects.Restourant;
import com.example.audrius.restix.viewholder.RestourantViewHolder;

import java.util.ArrayList;
import java.util.logging.Handler;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment{
    public static MainFragment getMainFragment() {
        return mainFragment;
    }

    public static void setMainFragment(MainFragment mainFragment) {
        MainFragment.mainFragment = mainFragment;
    }

    private static MainFragment mainFragment;

    public final RestourantAdapter adapter= new RestourantAdapter(DataService.getInstance().getDataRest());
    private BarAdapter barAdapter = new BarAdapter(DataService.getInstance().getDataRest());
    public final CafeeAdapter cafeeAdapter = new CafeeAdapter(DataService.getInstance().getDataRest());




    public MainFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        MainFragment.setMainFragment(this);
        //declaring buttons

        ImageButton restaurantCatBtn = (ImageButton)view.findViewById(R.id.restoranai);
        ImageButton cafeeCatBrn = (ImageButton)view.findViewById(R.id.kavines);
        ImageButton barCatBtn = (ImageButton)view.findViewById(R.id.barai);


        final RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);


        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);



        restaurantCatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final RestAdapter restAdapter = new RestAdapter(DataService.getInstance().getDataRest());
                recyclerView.setAdapter(restAdapter);

            }
        });
        cafeeCatBrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                recyclerView.setAdapter(cafeeAdapter);

            }
        });
        barCatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(barAdapter);


            }
        });



        return view;
    }

    public void remove(ArrayList<Restourant> restourants, int position) {


        restourants.remove(position);
        cafeeAdapter.notifyItemRemoved(position);

    }


}
