package com.example.android.tourguideapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Piratheepa on 4-4-2018.
 */

public class EventsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sights);
    }

    public void openlightfestival (View view){
        if (view.getId() == R.id.lightfestival) {
            Intent i = new Intent(EventsActivity.this, LightFestifalActivity.class);
            startActivity(i);
        }
    }
}