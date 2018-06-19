package com.example.android.musicstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Piratheepa on 1-4-2018.
 */

public class ArtistActivity extends AppCompatActivity {
    int[] IMAGES = {R.drawable.baekhyun, R.drawable.chanyeol, R.drawable.taehyung, R.drawable.chen, R.drawable.exo, R.drawable.bts};
    String ArtistNames[] = new String [] {"Baekhyun", "Chanyeol", "Taehyung", "Chen", "EXO", "BTS"};
    String TitleNames[] = new String [] {"Beautiful", "Stay with me", "Even if die, it's you", "Everytime", "EXO", "BTS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        ListView listView = (ListView) findViewById(R.id.ListView);

        ArtistAdapter artistAdapter = new ArtistAdapter();

        listView.setAdapter(artistAdapter);
    }

    class ArtistAdapter extends BaseAdapter{

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
            view = getLayoutInflater().inflate(R.layout.artist_layout, null);

            ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
            TextView artist_name = (TextView)view.findViewById(R.id.artist_name);
            TextView title_name = (TextView)view.findViewById(R.id.title_name);

            imageView.setImageResource(IMAGES[i]);
            artist_name.setText(ArtistNames[i]);
            title_name.setText(TitleNames[i]);

            return view;
        }
    }

    public void openartist(View view) {
        if(view.getId() == R.id.Artist_ID){
            Intent i = new Intent(ArtistActivity.this, SongsActivity.class );
            startActivity(i);
        }
    }
}
