package com.example.android.tourguideapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Piratheepa on 4-4-2018.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void opensights(View view) {
        if(view.getId() == R.id.sight){
            Intent i = new Intent(MainActivity.this, SightsActivity.class );
            startActivity(i);
        }
    }

    public void openevents(View view) {
        if(view.getId() == R.id.events){
            Intent i = new Intent(MainActivity.this, EventsActivity.class );
            startActivity(i);
        }
    }

    public void openshops(View view) {
        if(view.getId() == R.id.shops){
            Intent i = new Intent(MainActivity.this, ShopActivity.class );
            startActivity(i);
        }
    }
}