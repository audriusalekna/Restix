package com.example.audrius.restix.adapters;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.example.audrius.restix.R;
import com.example.audrius.restix.activities.OrderActivity;
import com.example.audrius.restix.objects.Menu;
import com.example.audrius.restix.viewholder.MenuViewHolder;
import com.example.audrius.restix.viewholder.RestourantViewHolder;

import java.util.ArrayList;

/**
 * Created by audrius on 22/02/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    private ArrayList<Menu> menus;
    private double totalprice = 0;

    public MenuAdapter(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public void onBindViewHolder(final MenuViewHolder holder, int position) {
        final Menu menu = menus.get(position);

        Bundle bundle = new Bundle();
        Double price = menu.getPrice();

        holder.menuCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(holder.menuCheckBox.isChecked()){
                    OrderActivity.getOrderActivity().addPrice(menu.getPrice());
                }
                else if (!holder.menuCheckBox.isChecked()){
                    OrderActivity.getOrderActivity().subPrice(menu.getPrice());
                }
            }
        });


        bundle.putDouble("price", price);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View menuCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_menu, null);



        return new MenuViewHolder(menuCard);
    }
}
