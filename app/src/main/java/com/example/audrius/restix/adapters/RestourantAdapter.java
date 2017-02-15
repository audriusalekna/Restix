package com.example.audrius.restix.adapters;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.audrius.restix.R;
import com.example.audrius.restix.activities.MainActivity;
import com.example.audrius.restix.fragments.RestaurantFragment;
import com.example.audrius.restix.objects.Restourant;
import com.example.audrius.restix.viewholder.RestourantViewHolder;

import java.util.ArrayList;

/**
 * Created by audrius on 14/12/16.
 */

public class RestourantAdapter extends RecyclerView.Adapter<RestourantViewHolder> {
    private ArrayList<Restourant> restourants;


    public RestourantAdapter(ArrayList<Restourant> restourants) {
        this.restourants = restourants;
    }

    @Override
    public int getItemCount() {
        return restourants.size();
    }

    @Override
    public RestourantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View restourantCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);


        return new RestourantViewHolder(restourantCard);
    }

    @Override
    public void onBindViewHolder(RestourantViewHolder holder, int position) {
        final Restourant restourant = restourants.get(position);

        holder.UpdateUI(restourant, true);

        final RestaurantFragment restaurantFragment = RestaurantFragment.newInstance();



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getMainActivity().loadRestaurantScreen(restourant , restaurantFragment);
            }
        });


        Bundle bundle = new Bundle();
        String title = restourant.getTitle().toString();
        String imgUri = restourant.getImgUrl().toString();

        bundle.putFloat("Lng",restourant.getLng());
        bundle.putFloat("Lat", restourant.getLat());
        bundle.putString("title", title);
        bundle.putString("imgUri", imgUri);
        bundle.putString("adress", restourant.getAdress().toString());
        bundle.putString("rating", String.valueOf(restourant.getRating()));

        restaurantFragment.setArguments(bundle);







            }





}



