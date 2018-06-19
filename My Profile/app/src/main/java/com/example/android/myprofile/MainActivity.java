package com.example.android.myprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button studentenbutton = (Button) findViewById(R.id.btnStudenten);
        Button studentbutton = (Button) findViewById(R.id.btnStudent);
        Button resultsbutton = (Button) findViewById(R.id.btnResults);
        Button dierbutton = (Button) findViewById(R.id.btnDier);

        studentenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Studenten = new Intent(view.getContext(), StudentenActivity.class);
                startActivity(Studenten);
            }
        });

        studentbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Student = new Intent(view.getContext(), MijnInfoActivity.class);
                startActivity(Student);
            }
        });

        resultsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Results = new Intent(view.getContext(), ResultsActivity.class);
                startActivity(Results);
            }
        });

        dierbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent FavDier = new Intent(view.getContext(), FavDierActivity.class);
                startActivity(FavDier);
            }
        });
    }
}
