package com.example.android.musicstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNowisPlaying(View view) {
        if(view.getId() == R.id.ID_playing){
            Intent i = new Intent(MainActivity.this, PlayingActivity.class );
            startActivity(i);
        }
    }

    public void openAlbum(View view) {
        if(view.getId() == R.id.ID_album){
            Intent i = new Intent(MainActivity.this, AlbumActivity.class );
            startActivity(i);
        }
    }

    public void openArtist(View view) {
        if(view.getId() == R.id.ID_artist){
            Intent i = new Intent(MainActivity.this, ArtistActivity.class );
            startActivity(i);
        }
    }

    public void openSongs(View view) {
        if(view.getId() == R.id.ID_songs){
            Intent i = new Intent(MainActivity.this, SongsActivity.class );
            startActivity(i);
        }
    }

}
