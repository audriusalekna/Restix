package com.example.audrius.restix.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.audrius.restix.R;
import com.example.audrius.restix.Services.DataService;
import com.example.audrius.restix.adapters.MenuAdapter;
import com.example.audrius.restix.adapters.RestourantAdapter;

public class OrderActivity extends AppCompatActivity {
    public static OrderActivity getOrderActivity() {
        return orderActivity;
    }

    private TextView priceText;
    private double totalPrice = 0;
    public final MenuAdapter adapter= new MenuAdapter(DataService.getInstance().getDataMenu());

    public static void setOrderActivity(OrderActivity orderActivity) {
        OrderActivity.orderActivity = orderActivity;
    }

    private static OrderActivity orderActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderActivity.setOrderActivity(this);
        setContentView(R.layout.activity_order);


        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view_menu);


        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        priceText = (TextView)findViewById(R.id.priceText);



    }

    public void addPrice(Double price){
        totalPrice = totalPrice+price;

        priceText.setText("Total price:" + totalPrice);
    }

    public void subPrice(Double price){
        totalPrice = totalPrice-price;

        priceText.setText("Total price:" + totalPrice);
    }
}
