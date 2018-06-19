package com.example.android.myprofile;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

public class StudentenActivity extends AppCompatActivity {


    private Button objButton;
    private ListView objListView;
    private ArrayList<Studenten> productList = new ArrayList<Studenten>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studenten);

        objButton = (Button)findViewById(R.id.objButton);
        objListView = (ListView)findViewById(R.id.objListView);

        objButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetJSon objGetJSon = new GetJSon();
                objGetJSon.execute();
            }
        });
    }
    public class GetJSon extends AsyncTask<String, Void, ArrayList<Studenten>> {
        private String line = "";
        private String data = "";

        @Override
        protected ArrayList<Studenten> doInBackground(String... strings) {

            ArrayList<Studenten> studentList = new ArrayList<>();
            try {
                URL url = new URL("http://mgroesink-001-site7.itempurl.com/api/Students/0267400");
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

                    Studenten objStudent = new Studenten((String)jsonObj.get("Education"),
                            (String)jsonObj.get("FirstName"), (String)jsonObj.get("Gender"),
                            (String)jsonObj.get("LastName"), (String)jsonObj.get("MiddleName"),
                            (String)jsonObj.get("Residence"), (String)jsonObj.get("StudentNr"));

                    studentList.add(objStudent);
                }

            } catch (MalformedURLException e) {
                Toast.makeText(StudentenActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return studentList;
        }

        @Override
        protected void onPostExecute(ArrayList<Studenten> studentlist) {
            StudentenAdapter objStudentsAdapter = new StudentenAdapter(StudentenActivity.this, studentlist);
            objListView.setAdapter(objStudentsAdapter);
        }
    }


}

