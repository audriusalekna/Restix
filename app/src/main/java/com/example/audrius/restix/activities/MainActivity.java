package com.example.audrius.restix.activities;




import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.audrius.restix.R;
import com.example.audrius.restix.fragments.MainFragment;
import com.example.audrius.restix.fragments.RestaurantFragment;
import com.example.audrius.restix.objects.Restourant;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    public static MainActivity getMainActivity() {
        return mainActivity;
    }
    public EditText timerText;
    private Handler handler;


    public static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    private static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainActivity.setMainActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment)fragmentManager.findFragmentById(R.id.main_container);

        if(mainFragment == null){
            mainFragment = MainFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.main_container , mainFragment).commit();
        }


    }
    public void loadRestaurantScreen(Restourant restourant, RestaurantFragment restaurantFragment){

        getSupportFragmentManager().beginTransaction().replace(R.id.main_container , restaurantFragment).addToBackStack(null).commit();

    }
    public void showDialog() {

        //starting new reservation dialog
        Intent myIntent = new Intent(this, ReservationActivity.class);
        this.startActivity(myIntent);

    }


}
