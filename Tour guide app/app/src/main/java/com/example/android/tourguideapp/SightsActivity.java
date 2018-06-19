package com.example.android.tourguideapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Piratheepa on 4-4-2018.
 */

public class SightsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sights);
    }

        public void openTulpen (View view){
            if (view.getId() == R.id.tulpen) {
                Intent i = new Intent(SightsActivity.this, TulpenActivity.class);
                startActivity(i);
            }
        }
}
