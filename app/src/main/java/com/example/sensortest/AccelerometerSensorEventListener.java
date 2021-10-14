package com.example.sensortest;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class AccelerometerSensorEventListener implements SensorEventListener {


    @Override
    public void onSensorChanged(SensorEvent event) {
        System.out.println("Event occurred: " + event);
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            MainActivity.GetXTextView().setText("X: " + event.values[0]);
            MainActivity.GetYTextView().setText("Y: " + event.values[1]);
            MainActivity.GetZTextView().setText("Z: " + event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
