package com.example.sensortest;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class MainActivity extends WearableActivity {

    private static TextView x,y,z;
    public static TextView GetXTextView() {
        return x;
    }
    public static TextView GetYTextView() {
        return y;
    }
    public static TextView GetZTextView() {
        return z;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enables Always-on
        setAmbientEnabled();

        x = this.findViewById(R.id.X);
        y = this.findViewById(R.id.Y);
        z = this.findViewById(R.id.Z);

        System.out.println("Hello World");
        SensorEventListener listener = new AccelerometerSensorEventListener();
        System.out.println("listener not null = " + (listener != null));

        SensorManager sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        System.out.println("sensor manager not null = " + (sensorManager != null));

        System.out.println("deafault sensors = " + (sensorManager.getSensorList(Sensor.TYPE_ALL)));

        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        System.out.println("accelerometer not null = " + (accelerometer != null));

        boolean registered = sensorManager.registerListener(listener, accelerometer, sensorManager.SENSOR_DELAY_FASTEST, 6*1000*1000);
        System.out.println("REGISTERED = " + registered);
    }



}