package com.example.android.sensoroverzicht;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SensorDataActivity extends AppCompatActivity implements SensorEventListener {

    // SensorManager
    private SensorManager mSensorManager;

    // Individual light and proximity sensors
    private Sensor mSensorProximity;
    private Sensor mSensorLight;

    // TextViews to display current sensor values
    private TextView mTextSensorLight;
    private TextView mTextSensorProximity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sensor_data);

        mTextSensorLight = (TextView) findViewById(R.id.label_light);
        mTextSensorProximity = (TextView) findViewById(R.id.label_proximity);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //De Methode getDefaultSensor zoekt naar een sensor voor het opgegeven type.
        // Als er geen sensor is dan geeft de methode null als resultaat terug.
        mSensorProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mSensorLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        //de foutmelding uit het resourcebestand in op te slaan.
        String error = getString(R.string.error_no_sensor);

        //Controleer of er een sensor is gevonden en toon de foutmelding als er geen sensor is
        if (mSensorLight == null)
        {
            mTextSensorLight.setText(error);
        }

        if (mSensorProximity == null)
        {
            mTextSensorProximity.setText(error);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        int sensorType = sensorEvent.sensor.getType();
        float currentValue = sensorEvent.values[0];

        switch (sensorType)
        {
            case Sensor.TYPE_LIGHT:
                // Handle light sensor changes
                mTextSensorLight.setText(getString(R.string.label_light , currentValue));
                break;

            case Sensor.TYPE_PROXIMITY:
                // Handle proximity sensor changes
                mTextSensorProximity.setText(getString(R.string.label_proximity , currentValue));
                break;

            default:
                // Do nothing
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        if (mSensorLight != null )
        {
            mSensorManager.registerListener(this , mSensorLight , SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorProximity != null )
        {
            mSensorManager.registerListener(this , mSensorProximity , SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        mSensorManager.unregisterListener(this);
    }

}
