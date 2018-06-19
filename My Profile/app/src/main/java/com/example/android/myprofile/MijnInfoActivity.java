package com.example.android.myprofile;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MijnInfoActivity extends AppCompatActivity {
    private String JSON_Url = "http://mgroesink-001-site7.itempurl.com/api/Students/0267400/588A6A6X2X";
    TextView sName, sLoc, sClass, sEdu, sCrebo, sStudentnr, sGender, sBirthplace, sAnimal, sDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mijn_info);

        sName = findViewById(R.id.name);
        sLoc = findViewById(R.id.location);
        sClass = findViewById(R.id.klas);
        sEdu = findViewById(R.id.edu);
        sCrebo = findViewById(R.id.crebo);
        sStudentnr = findViewById(R.id.studentnr);
        sGender = findViewById(R.id.gender);
        sBirthplace = findViewById(R.id.birthplace);
        sAnimal = findViewById(R.id.animal);
        sDOB = findViewById(R.id.DOB);

        GetJSon objGetJSon = new GetJSon();
        objGetJSon.execute();
    }

    class GetJSon extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            StringBuilder result = new StringBuilder();

            try {
                URL url = new URL("http://mgroesink-001-site7.itempurl.com/api/Students/0267400/588A6A6X2X");
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream in = httpURLConnection.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

            } catch (MalformedURLException e) {
                Toast.makeText(MijnInfoActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject jsonObject = new JSONObject(result);

                String address = jsonObject.getString("Address");
                String animal = jsonObject.getString("Animal");
                String birthdate = jsonObject.getString("BirthDate");
                String birthplace = jsonObject.getString("BirthPlace");
                String aclass = jsonObject.getString("Class");
                String crebo = jsonObject.getString("Crebo");
                String education = jsonObject.getString("Education");
                String firstname = jsonObject.getString("FirstName");
                String gender = jsonObject.getString("Gender");
                String lastname = jsonObject.getString("LastName");
                String middlename = jsonObject.getString("MiddleName");
                String postalcode = jsonObject.getString("PostalCode");
                String residence = jsonObject.getString("Residence");
                String studentnr = jsonObject.getString("StudentNr");


                sName.setText(firstname + "" + middlename + "" + lastname);
                sLoc.setText(address + ", " + residence + ", " + postalcode);
                sClass.setText(aclass);
                sEdu.setText(education);
                sCrebo.setText(crebo);
                sStudentnr.setText(studentnr);
                sGender.setText(gender);
                sBirthplace.setText(birthplace);
                sAnimal.setText(animal);
                sDOB.setText(birthdate.substring(0,10));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
