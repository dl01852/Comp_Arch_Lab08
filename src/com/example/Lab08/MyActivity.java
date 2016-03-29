package com.example.Lab08;

import android.app.Activity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    TextView txtLightSensor, txtHumiditySensor, txtAmbientPressure, txtAmbientTemperature; // TextViews for all the sensors

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        txtLightSensor = (TextView)findViewById(R.id.lightSensor);
        txtHumiditySensor = (TextView) findViewById(R.id.humiditySensor);
        txtAmbientPressure = (TextView) findViewById(R.id.ambientPressure);
        txtAmbientTemperature = (TextView) findViewById(R.id.ambientTemperature);

        // grabbing the sensorManger and the sensors
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        Sensor humiditySensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        Sensor ambientPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        Sensor ambientTemperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);


        // Are the sensors present?
        txtLightSensor.setText(lightSensor == null ? "Light Sensor is absent" : "Light Sensor is present");
        txtHumiditySensor.setText(humiditySensor == null? "Humidity Sensor is absent" : "Humidity Sensor is present");
        txtAmbientPressure.setText(ambientPressure == null? "Ambient pressure is absent" : "Ambient pressure is present");
        txtAmbientTemperature.setText(ambientTemperature == null? "Ambient temperature is absent" : "Ambient temperature is present");
    }
}
