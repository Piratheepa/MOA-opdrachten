package com.example.android.musicstructureapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Piratheepa on 4-4-2018.
 */

public class SongsActivity extends Activity {
    int[] IMAGES = {R.drawable.album1, R.drawable.album2, R.drawable.album1, R.drawable.album3, R.drawable.album4, R.drawable.album2};
    String SongsNames[] = new String[]{"Don't Go", "Love, Love, Love", "Peter Pan", "Exodus", "Lucky One", "Thunder"};
    String ArtistsNames[] = new String[]{"EXO", "EXO", "EXO", "EXO", "EXO", "EXO"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        ListView listView = (ListView) findViewById(R.id.ListView);

        SongsActivity.SongsAdapter songsAdapter = new SongsActivity.SongsAdapter();

        listView.setAdapter(songsAdapter);
    }

    class SongsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.songs_layout, null);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView song_name = (TextView) view.findViewById(R.id.song_name);
            TextView artists_name = (TextView) view.findViewById(R.id.artists_name);

            imageView.setImageResource(IMAGES[i]);
            song_name.setText(SongsNames[i]);
            artists_name.setText(ArtistsNames[i]);

            return view;
        }
    }


        public void opensong(View view) {
            if (view.getId() == R.id.Song_ID) {
                Intent i = new Intent(SongsActivity.this, PlayingActivity.class);
                startActivity(i);
            }
        }
}