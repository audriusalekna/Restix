package com.example.audrius.restix.viewholder;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.audrius.restix.R;
import com.example.audrius.restix.fragments.MainFragment;
import com.example.audrius.restix.fragments.RestaurantFragment;
import com.example.audrius.restix.objects.Restourant;

/**
 * Created by audrius on 14/12/16.
 */

public class RestourantViewHolder extends RecyclerView.ViewHolder{
    private ImageView mainImage;
    private TextView title;
    private TextView adress;
    private TextView reting;

    //Buttons for categories
    private ImageButton restaurantBtn;
    private ImageButton barBtn;
    private ImageButton cafeeBtn;




    public RestourantViewHolder(View itemView) {
        super(itemView);
        this.mainImage = (ImageView) itemView.findViewById(R.id.main_image);
        this.title = (TextView) itemView.findViewById(R.id.title_text);
        this.adress = (TextView) itemView.findViewById(R.id.adress);
        this.reting = (TextView) itemView.findViewById(R.id.ratingText);


    }
    public void UpdateUI(final Restourant restourant, boolean bool){


        //Upadating interface for the 1st time

        String uri = restourant.getImgUrl();
        int resource = mainImage.getResources().getIdentifier(uri, null, mainImage.getContext().getPackageName());
        String ratingText = String.valueOf(restourant.getRating());
        mainImage.setImageResource(resource);
        Log.v("DONKEY", "Res" + resource);
        title.setText(restourant.getTitle());
        adress.setText(restourant.getAdress());
        reting.setText("Rating: " + ratingText);


    }
    public void UpdateCat(final Restourant restourant, boolean bool){


        //Upadating interface for the 1st time
        if(bool == true) {
            String uri = restourant.getImgUrl();
            int resource = mainImage.getResources().getIdentifier(uri, null, mainImage.getContext().getPackageName());
            String ratingText = String.valueOf(restourant.getRating());
            mainImage.setImageResource(resource);
            mainImage.getDrawable().setAlpha(244);
            Log.v("DONKEY", "Res" + resource);
            title.setText(restourant.getTitle());
            adress.setText(restourant.getAdress());
            reting.setText("Rating: " + ratingText);
        }
        else{
            itemView.setVisibility(View.GONE);
        }

    }





}

