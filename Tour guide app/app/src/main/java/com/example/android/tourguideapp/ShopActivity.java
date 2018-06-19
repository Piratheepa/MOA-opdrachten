package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Piratheepa on 4-4-2018.
 */

public class ShopActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
    }

    public void openiam(View view) {
        if(view.getId() == R.id.iam_store){
            Intent i = new Intent(ShopActivity.this, IamstoreActivity.class );
            startActivity(i);
        }
    }
}