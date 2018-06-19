package com.example.android.musicstructureapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Piratheepa on 1-4-2018.
 */

public class AlbumActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
    }

    public void openxoalbum(View view) {
        if (view.getId() == R.id.Album1) {
            Intent i = new Intent(AlbumActivity.this, SongsActivity.class);
            startActivity(i);
        }
    }
}
