package com.example.audrius.restix.viewholder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.audrius.restix.R;
import com.example.audrius.restix.activities.OrderActivity;
import com.example.audrius.restix.objects.Menu;
import com.example.audrius.restix.objects.Restourant;

/**
 * Created by audrius on 22/02/2017.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder {
    private ImageView menuImage;
    TextView title;
    private TextView ingridients;
    private TextView price;
    public CheckBox menuCheckBox;
    private double totalprice = 0;


    public MenuViewHolder(final View itemView) {
        super(itemView);
        menuImage = (ImageView)itemView.findViewById(R.id.menuImage);
        title = (TextView)itemView.findViewById(R.id.menu_title_text);
        ingridients = (TextView)itemView.findViewById(R.id.menu_text_ingreds);
        price = (TextView)itemView.findViewById(R.id.menu_price);
        menuCheckBox = (CheckBox) itemView.findViewById(R.id.menu_check_box);

    }


}

