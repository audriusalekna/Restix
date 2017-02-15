package com.example.audrius.restix.adapters;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.audrius.restix.R;
import com.example.audrius.restix.activities.MainActivity;
import com.example.audrius.restix.fragments.RestaurantFragment;
import com.example.audrius.restix.objects.Restourant;
import com.example.audrius.restix.viewholder.RestourantViewHolder;

import java.util.ArrayList;

/**
 * Created by audrius on 19/01/17.
 */

public class RestAdapter extends RecyclerView.Adapter<RestourantViewHolder> {
    private ArrayList<Restourant> restourants;


    public RestAdapter(ArrayList<Restourant> restourants) {
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
    public void onBindViewHolder(final RestourantViewHolder holder, int position) {
        final Restourant restourant = restourants.get(position);
        Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                int newPosition = holder.getAdapterPosition();
                if(restourant.getCat() == "rest" && newPosition >= 0 && newPosition <restourants.size()){
                    holder.UpdateCat(restourant, true);
                }
                else if(restourant.getCat()!="rest" && newPosition >= 0 && newPosition <restourants.size()){
                    restourants.remove(newPosition);
                    notifyItemRemoved(newPosition);
                    notifyItemRangeChanged(newPosition , restourants.size());
                    holder.UpdateCat(restourant,false);
                }
            }
        };
        handler.post(r);


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
