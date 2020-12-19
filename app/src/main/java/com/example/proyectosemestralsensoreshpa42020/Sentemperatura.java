package com.example.proyectosemestralsensoreshpa42020;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static android.text.TextUtils.concat;

public class Sentemperatura extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mTempSensor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentemperatura);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mTempSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    public void Sentemperatura() {
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mTempSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mTempSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        //Sensor mySensor = sensorEvent.sensor;
        float temp = sensorEvent.values[0];
        TextView tvTemp;
        tvTemp=findViewById(R.id.tvTemp);

        tvTemp.setText(concat(String.valueOf(temp), " Lumens"));
    }
}