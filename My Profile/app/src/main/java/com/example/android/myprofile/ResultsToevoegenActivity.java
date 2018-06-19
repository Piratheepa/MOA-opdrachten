package com.example.android.myprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResultsToevoegenActivity extends AppCompatActivity {

    private String JSON_Url = "http://mgroesink-001-site7.itempurl.com/api/Results/0267400";
    String studentnr;
    String coursecode;
    String resultdate;
    Double score;

    Button insertScoreBtn;
    Spinner courseCodeSP;
    static final String[]paths = {"MOA", "NED", "ENG", "DBD", "FTD", "LBB", "BKD", "REK"};
    EditText resultET;
    EditText resultDateET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_toevoegen);

        courseCodeSP = (Spinner)findViewById(R.id.setCourseCode);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ResultsToevoegenActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseCodeSP.setAdapter(adapter);

        insertScoreBtn = findViewById(R.id.btnInsertScore);

        insertScoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInfo();
                sendPost();
                clearInput();
            }
        });

    }

    public void getInfo(){


        courseCodeSP = findViewById(R.id.setCourseCode);
        resultET = findViewById(R.id.setResult);
        resultDateET = (EditText) findViewById(R.id.setResultDate);
        resultDateET.setInputType(InputType.TYPE_NULL);
        resultDateET.requestFocus();

        studentnr = "0267400";

        coursecode = courseCodeSP.getSelectedItem().toString();
        if(resultET.getText().toString() != ""){
            Double scoreinput = Double.parseDouble(resultET.getText().toString());
            if(scoreinput > 0 && scoreinput <= 10){
                score = scoreinput;
            }
        }
        else{
            Toast.makeText(ResultsToevoegenActivity.this, "Voer een geldig cijfer in!", Toast.LENGTH_LONG).show();
        }

        resultdate = resultDateET.getText().toString();

    }

    public void clearInput(){
        courseCodeSP.setSelection(0);
        resultET.setText("");
        resultDateET.getText().clear();
    }

    public void sendPost() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(JSON_Url);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept","application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("StudentNr", studentnr);
                    jsonParam.put("CourseCode", coursecode);
                    jsonParam.put("ResultDate", resultdate);
                    jsonParam.put("Score", score);

                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    os.writeBytes(jsonParam.toString());

                    os.flush();
                    os.close();

                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG" , conn.getResponseMessage());

                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
}

