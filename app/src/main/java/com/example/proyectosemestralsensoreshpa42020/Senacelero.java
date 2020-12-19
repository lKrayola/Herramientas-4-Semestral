package com.example.proyectosemestralsensoreshpa42020;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import java.util.Random;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class Senacelero extends AppCompatActivity implements SensorEventListener{

    //vainas del acelerometro
    private SensorManager senSensorManager;
    private Sensor senAccelerometer;
    //datos del sensor acelerometro
    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD = 600;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senacelero);
        senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senSensorManager.registerListener(this, senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor mySensor = sensorEvent.sensor;
        TextView val1,val2,val3,val4,val5,val6;
        val1=findViewById(R.id.val1);
        val2=findViewById(R.id.val2);
        val3=findViewById(R.id.val3);
        val4=findViewById(R.id.val4);
        val5=findViewById(R.id.val5);
        val6=findViewById(R.id.val6);

        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            //ejes
            if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];
                final Random myRandom = new Random();

                long curTime = System.currentTimeMillis();

                if ((curTime - lastUpdate) > 100) {
                    long diffTime = (curTime - lastUpdate);
                    lastUpdate = curTime;

                    float speed = Math.abs(x + y + z - last_x - last_y - last_z)/ diffTime * 10000;

                    if (speed > SHAKE_THRESHOLD) {
                       //poner aqui lo q debe pasar
                        val1.setText(String.valueOf(myRandom.nextInt(100)));
                        val2.setText(String.valueOf(myRandom.nextInt(100)));
                        val3.setText(String.valueOf(myRandom.nextInt(100)));
                        val4.setText(String.valueOf(myRandom.nextInt(100)));
                        val5.setText(String.valueOf(myRandom.nextInt(100)));
                        val6.setText(String.valueOf(myRandom.nextInt(100)));

                    }

                    last_x = x;
                    last_y = y;
                    last_z = z;
                }
            }
        }}


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    //cuando se apague la pantalla deja de funcionar el sensor
    protected void onPause() {
        super.onPause();
        senSensorManager.unregisterListener(this);
    }

    //el contrario al metodo anterior
    protected void onResume() {
        super.onResume();
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }



}