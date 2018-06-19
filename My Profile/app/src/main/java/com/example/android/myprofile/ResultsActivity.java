package com.example.android.myprofile;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {
    private String JSON_Url = "http://mgroesink-001-site7.itempurl.com/api/Results/0267400/588A6A6X2X";

    private Button addScoreButton;
    private ListView scoreListView;
    private ArrayList<Studenten> productList = new ArrayList<Studenten>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        scoreListView = (ListView) findViewById(R.id.scoreListView);
        addScoreButton = (Button) findViewById(R.id.btnScore);

        GetJSon objGetJSon = new GetJSon();
        objGetJSon.execute();


        addScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insert = new Intent(view.getContext(), ResultsToevoegenActivity.class);
                startActivity(insert);
            }
        });
    }

    public class GetJSon extends AsyncTask<String, Void, ArrayList<Results>> {
        private String line = "";
        private String data = "";

        @Override
        protected ArrayList<Results> doInBackground(String... strings) {
            ArrayList<Results> scoreList = new ArrayList<Results>();
            try {
                URL url = new URL("http://mgroesink-001-site7.itempurl.com/api/Results/0267400/588A6A6X2X");
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                while(line != null){
                    line = bufferedReader.readLine();
                    data += line;
                }

                JSONArray jsonArray = new JSONArray(data);
                int length = jsonArray.length();
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonObj = (JSONObject)jsonArray.get(i);

                    Results objScore = new Results((String)jsonObj.get("CourseCode"),
                            (Double)jsonObj.get("Result"), (String)jsonObj.get("ResultDate"),
                            (String)jsonObj.get("StudentNr"), (String)jsonObj.get("Title"));

                    scoreList.add(objScore);
                }

            } catch (MalformedURLException e) {
                Toast.makeText(ResultsActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return scoreList;
        }
        @Override
        protected void onPostExecute(ArrayList<Results> scoreList) {
            ResultsAdapter objScoresAdapter = new ResultsAdapter(ResultsActivity.this, scoreList);
            scoreListView.setAdapter(objScoresAdapter);
        }
    }
}
