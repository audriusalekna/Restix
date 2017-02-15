package com.example.audrius.restix.fragments;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.audrius.restix.R;

import com.example.audrius.restix.activities.MainActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RestaurantFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private Context globalContext = null;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    MapView mMapView;
    private GoogleMap googleMap;


    public RestaurantFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static RestaurantFragment newInstance() {
        RestaurantFragment fragment = new RestaurantFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);// Inflate the layout for this fragment
        TextView textView = (TextView) view.findViewById(R.id.restaurant_last_text);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView adress = (TextView) view.findViewById(R.id.adress);
        TextView rating = (TextView) view.findViewById(R.id.rating);

        final Bundle bundle = this.getArguments();
        String myInt = bundle.getString("title");
        String img = bundle.getString("imgUri");
        int resource = imageView.getResources().getIdentifier(img, null, imageView.getContext().getPackageName());

        //Setting bundles for restaurant views

        imageView.setImageResource(resource);
        imageView.getDrawable().setAlpha(86);
        textView.setText(myInt);
        adress.setText("Adress: " + bundle.getString("adress"));
        rating.setText("Rating: " + bundle.getString("rating"));

        // Setting up map and map Marker

        SupportMapFragment mSupportMapFragment;

        mSupportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mSupportMapFragment == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mSupportMapFragment = SupportMapFragment.newInstance();
            fragmentTransaction.replace(R.id.map, mSupportMapFragment).commit();
        }

        if (mSupportMapFragment != null) {
            mSupportMapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    if (googleMap != null) {

                        googleMap.getUiSettings().setAllGesturesEnabled(true);


                        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(bundle.getFloat("Lat") , bundle.getFloat("Lng"))).zoom(15f).build();
                        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
                        googleMap.moveCamera(cameraUpdate);
                        Marker marker = googleMap.addMarker(new MarkerOptions()
                                .position(new LatLng(bundle.getFloat("Lat") , bundle.getFloat("Lng")))
                                .title("San Francisco")
                                .snippet("Population: 776733"));


                    }

                }
            });


        }

        Button callBtn =(Button)view.findViewById(R.id.callBtn);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + 867787585));

                    startActivity(intent);


            }
        });

        final Button reservationBtn = (Button)view.findViewById(R.id.reservationBtn);

        reservationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getMainActivity().showDialog();
            }
        });

        


        return view;

}


}
